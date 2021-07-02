package io.imagineobjects.linguinai;

import java.util.List;

/**
 * Linguin AI in Java.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
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
     * @return List of Languages.
     */
    List<Languages> bulkDetect(final String... texts);
}
