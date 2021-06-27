package io.imagineobjects.linguinai;

import javax.json.JsonValue;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * JSON resources of the API.
 * @author Mihai Andronache (amihiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
interface JsonResources {

    /**
     * Return an instance which has an accessToken for
     * making authenticated requests.
     * @param accessToken Access token.
     * @return JsonResources.
     */
    JsonResources authenticated(final AccessToken accessToken);

    /**
     * Get the Resource at the specified URI.
     * @param uri Resource location.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    default Resource get(final URI uri){
        return this.get(uri, Collections::emptyMap);
    }

    /**
     * Get the Resource at the specified URI.
     * @param uri Resource location.
     * @param headers HTTP Headers.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    Resource get(
        final URI uri,
        final Supplier<Map<String, List<String>>> headers
    );

    /**
     * Post a JsonObject to the specified URI.
     * @param uri URI.
     * @param body JSON body of the request.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    default Resource post(
        final URI uri,
        final JsonValue body
    ){
        return this.post(uri, Collections::emptyMap, body);
    }

    /**
     * Post a JsonObject to the specified URI.
     * @param uri URI.
     * @param headers HTTP Headers.
     * @param body JSON body of the request.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    Resource post(
        final URI uri,
        final Supplier<Map<String, List<String>>> headers,
        final JsonValue body
    );


    /**
     * Patch a JsonObject at the specified URI.
     * @param uri URI.
     * @param body JSON body of the request.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    default Resource patch(
        final URI uri,
        final JsonValue body
    ){
        return this.patch(uri, Collections::emptyMap, body);
    }

    /**
     * Patch a JsonObject at the specified URI.
     * @param uri URI.
     * @param body JSON body of the request.
     * @param headers HTTP Headers.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    Resource patch(
        final URI uri,
        final Supplier<Map<String, List<String>>> headers,
        final JsonValue body
    );


    /**
     * Put a JsonObject at the specified URI.
     * @param uri URI.
     * @param body JSON body of the request.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    default Resource put(
        final URI uri,
        final JsonValue body
    ){
        return this.put(uri, Collections::emptyMap, body);
    }

    /**
     * Put a JsonObject at the specified URI.
     * @param uri URI.
     * @param body JSON body of the request.
     * @param headers HTTP Headers.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    Resource put(
        final URI uri,
        final Supplier<Map<String, List<String>>> headers,
        final JsonValue body
    );

    /**
     * DELETE the specified resource.
     * @param uri URI.
     * @param body JSON body of the request.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    default Resource delete(
        final URI uri,
        final JsonValue body
    ){
        return this.delete(uri, Collections::emptyMap, body);
    }

    /**
     * DELETE the specified resource.
     * @param uri URI.
     * @param headers HTTP Headers.
     * @param body JSON body of the request.
     * @return Resource.
     * @throws IllegalStateException If IOException or InterruptedException
     *  occur while making the HTTP request.
     */
    Resource delete(
        final URI uri,
        final Supplier<Map<String, List<String>>> headers,
        final JsonValue body
    );

}
