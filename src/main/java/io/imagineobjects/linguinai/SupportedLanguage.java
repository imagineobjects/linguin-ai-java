package io.imagineobjects.linguinai;

/**
 * Language supported by Linguin.ai.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface SupportedLanguage {

    /**
     * Language code.
     * @return String.
     */
    String code();

    /**
     * Name(s) of the language in english.
     * @return String[].
     */
    String[] englishNames();

    /**
     * Name(s) of the language in said language.
     * @return String[].
     */
    String[] nativeNames();

}
