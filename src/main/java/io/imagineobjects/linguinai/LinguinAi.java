package io.imagineobjects.linguinai;

/**
 * Linguin AI in Java.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @todo #6:60min Continue implementing the API, with the single detection
 *  endpoint, then bulk detection etc.
 */
public interface LinguinAi {

    /**
     * Linguin AI account status.
     * @return Status.
     * @todo #6:60min Add unit tests for this method using MockJsonResources,
     *  similarly to how it's done in self-xdsd/self-core.
     */
    Status status();

}
