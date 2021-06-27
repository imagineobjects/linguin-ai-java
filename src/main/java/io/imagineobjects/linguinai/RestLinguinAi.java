package io.imagineobjects.linguinai;

import javax.json.JsonObject;
import java.net.HttpURLConnection;
import java.net.URI;

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
    public RestLinguinAi(final URI baseUri, final String token) {
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
}
