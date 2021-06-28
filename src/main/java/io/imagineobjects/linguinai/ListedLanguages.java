package io.imagineobjects.linguinai;

import java.util.Iterator;
import java.util.List;

/**
 * Languages in a List.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @todo #8:60min Finish implementing this class and write unit tests for it.
 */
final class ListedLanguages implements Languages {

    /**
     * List.
     */
    private final List<Language> languages;

    /**
     * Ctor.
     * @param languages List of languages.
     */
    ListedLanguages(final List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public Language bestMatch() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public Iterator<Language> iterator() {
        return this.languages.iterator();
    }
}
