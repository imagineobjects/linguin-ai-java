package io.imagineobjects.linguinai;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.List;
import java.util.Map;

/**
 * Resource returned by the API.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
interface Resource {

    /**
     * Status code.
     * @return Integer.
     */
    int statusCode();

    /**
     * This resource as JsonObject.
     * @return JsonObject.
     */
    JsonObject asJsonObject();

    /**
     * This resource as JsonArray.
     * @return JsonArray.
     */
    JsonArray asJsonArray();

    /**
     * Returns the resource as simple String.
     * @return String.
     */
    String body();

    /**
     * Resource headers.
     * @return Map of headers.
     */
    Map<String, List<String>> headers();

}
