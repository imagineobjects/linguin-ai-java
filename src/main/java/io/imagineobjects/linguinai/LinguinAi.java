package io.imagineobjects.linguinai;

/**
 * Linguin AI in Java.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @todo #8:60min Continue implementing the API, with the bulk detection
 *  endpoint. Allow user to specify encoding for each text.
 */
public interface LinguinAi {

    /**
     * Linguin AI account status.
     * @return Status.
     * @todo #6:60min Add unit tests for this method using MockJsonResources,
     *  similarly to how it's done in self-xdsd/self-core.
     */
    Status status();

    /**
     * Detect the possible languages of the given text.
     * Default encoding is UTF-8.
     * @param text Given text.
     * @return Languages.
     */
    Languages detect(final String text);

}
