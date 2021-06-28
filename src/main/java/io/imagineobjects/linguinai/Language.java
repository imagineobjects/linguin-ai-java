package io.imagineobjects.linguinai;

/**
 * Language detected by the API.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface Language {

    /**
     * Language code (en, de, fr etc).
     * @return String.
     */
    String code();

    /**
     * Confidence of the detection (0..1].
     * @return Double.
     */
    double confidence();
}
