package io.imagineobjects.linguinai;

/**
 * Languages detected by the API.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface Languages extends Iterable<Language> {

    /**
     * Returns the Language with the highest confidince.
     * @return Language.
     */
    Language bestMatch();
}
