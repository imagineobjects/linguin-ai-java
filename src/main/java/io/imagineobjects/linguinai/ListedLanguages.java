package io.imagineobjects.linguinai;

import java.util.Iterator;
import java.util.List;

/**
 * Languages in a List.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
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
        Language best = this.languages.get(0);
        for(int i = 1; i < this.languages.size(); i++) {
            if(this.languages.get(i).confidence() > best.confidence()) {
                best = languages.get(i);
            }
        }
        return best;
    }

    @Override
    public Iterator<Language> iterator() {
        return this.languages.iterator();
    }
}
