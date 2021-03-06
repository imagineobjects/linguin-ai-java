package io.imagineobjects.linguinai;

import javax.json.*;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Linguin AI REST client entry point.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RestLinguinAi implements LinguinAi {

    /**
     * Base API uri.
     */
    private final URI baseUri;

    /**
     * API json resources.
     */
    private final JsonResources resources;

    /**
     * Constructor. By default, the /v1 API base URI is being used.
     * @param token Access token.
     */
    public RestLinguinAi(final String token) {
        this(URI.create("https://api.linguin.ai/v1"), token);
    }

    /**
     * Ctor.
     * @param baseUri Base URI (e.g. https://api.linguin.ai/v1).
     * @param token Access token.
     */
    private RestLinguinAi(final URI baseUri, final String token) {
        this.baseUri = baseUri;
        this.resources = new JsonResources.JdkHttp().authenticated(
            new AccessToken.Bearer(token)
        );
    }

    @Override
    public Status status() {
        final Resource resource = this.resources.get(
            URI.create(this.baseUri + "/status")
        );
        if(resource.statusCode() != HttpURLConnection.HTTP_OK) {
            throw new IllegalStateException(
                "Call to /status returned status code " + resource.statusCode()
                + ", instead of 200 OK"
            );
        }
        return new Status() {

            /**
             * Status in JSON.
             */
            private final JsonObject json = resource.asJsonObject();

            @Override
            public int dailyLimit() {
                return this.json.getInt("daily_limit");
            }

            @Override
            public int detectionsToday() {
                return this.json.getInt("detections_today");
            }

            @Override
            public int remainingToday() {
                return this.json.getInt("remaining_today");
            }
        };
    }

    @Override
    public Languages detect(final String text){
        try {
            final Resource resource = this.resources.post(
                URI.create(
                    this.baseUri + "/detect?q="
                    + URLEncoder.encode(text, StandardCharsets.UTF_8.toString())
                ),
                Json.createObjectBuilder().build()
            );
            if (resource.statusCode() != HttpURLConnection.HTTP_OK) {
                throw new IllegalStateException(
                    "Call to /detect returned status code "
                    + resource.statusCode() + ", instead of 200 OK"
                );
            }
            final List<Language> languages = new ArrayList<>();
            final JsonArray results = resource.asJsonObject()
                .getJsonArray("results");
            for(final JsonValue lang : results) {
                languages.add(
                    new Language() {
                        @Override
                        public String code() {
                            return ((JsonObject) lang).getString("lang");
                        }

                        @Override
                        public double confidence() {
                            return ((JsonObject) lang)
                                .getJsonNumber("confidence")
                                .doubleValue();
                        }

                        @Override
                        public String toString() {
                            return this.code();
                        }
                    }
                );
            }
            return new ListedLanguages(languages);
        } catch (final UnsupportedEncodingException ex) {
            throw new IllegalStateException(
                "UnsupportedEncodingException when trying to detect language "
                + "of text [" + text + "] with Charset ["
                + StandardCharsets.UTF_8.toString() + "].",
                ex
            );
        }
    }

    @Override
    public BulkDetection bulkDetect(final String... texts) {
        try {
            final StringBuilder query = new StringBuilder();
            for(int i=0; i < texts.length; i++) {
                query.append("q[]=").append(
                    URLEncoder.encode(
                        texts[i],
                        StandardCharsets.UTF_8.toString()
                    )
                );
                if(i < texts.length -1) {
                    query.append("&");
                }
            }
            final Resource resource = this.resources.post(
                URI.create(
                    this.baseUri + "/bulk?" + query.toString()
                ),
                Json.createObjectBuilder().build()
            );
            if (resource.statusCode() != HttpURLConnection.HTTP_OK) {
                throw new IllegalStateException(
                    "Call to /bulk returned status code "
                    + resource.statusCode() + ", instead of 200 OK"
                );
            }
            final List<Languages> result = new ArrayList<>();
            final JsonArray jsonResults = resource.asJsonObject()
                .getJsonArray("results");
            for(final JsonValue detected : jsonResults) {
                List<Language> lang = new ArrayList<>();
                for(final JsonValue language : (JsonArray) detected) {
                    lang.add(
                        new Language() {
                            @Override
                            public String code() {
                                return ((JsonObject) language)
                                    .getString("lang");
                            }

                            @Override
                            public double confidence() {
                                return ((JsonObject) language)
                                    .getJsonNumber("confidence")
                                    .doubleValue();
                            }

                            @Override
                            public String toString() {
                                return this.code();
                            }
                        }
                    );
                }
                result.add(new ListedLanguages(lang));
            }
            return () -> result.iterator();
        } catch (final UnsupportedEncodingException ex) {
            throw new IllegalStateException(
                "UnsupportedEncodingException when trying to detect language "
                + "of texts " + Arrays.toString(texts) + " with Charset ["
                + StandardCharsets.UTF_8.toString() + "].",
                ex
            );
        }
    }

    @Override
    public SupportedLanguages languages() {
        final Resource resource = this.resources.get(
            URI.create(this.baseUri + "/languages")
        );
        if(resource.statusCode() != HttpURLConnection.HTTP_OK) {
            throw new IllegalStateException(
                "Call to /languages returned status code "
                + resource.statusCode() + ", instead of 200 OK"
            );
        }
        final List<SupportedLanguage> supported = new ArrayList<>();
        final JsonObject json = resource.asJsonObject();
        for(final String code : json.keySet()) {
            supported.add(
                new SupportedLanguage() {
                    @Override
                    public String code() {
                        return code;
                    }

                    @Override
                    public String[] englishNames() {
                        return json.getJsonArray(code)
                            .getString(0).split(";");
                    }

                    @Override
                    public String[] nativeNames() {
                        return json.getJsonArray(code)
                            .getString(1).split(";");
                    }
                }
            );
        }
        return () -> supported.iterator();
    }
}
