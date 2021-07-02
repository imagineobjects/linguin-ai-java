package io.imagineobjects.linguinai;

/**
 * Linguin AI in Java.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @todo #15:60min Implement the GET SupportedLanguages endpoint.
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

    /**
     * Detect the possible languages for more texts.
     * @param texts Texts to detect.
     * @return BulkDetection.
     */
    BulkDetection bulkDetect(final String... texts);
}
