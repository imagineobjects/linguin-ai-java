package io.imagineobjects.linguinai;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * Unit tests for {@link ListedLanguages}.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class ListedLanguagesTestCase {

    /**
     * ListedLanguages can be iterated.
     */
    @Test
    public void canBeIterated() {
        final Languages languages = new ListedLanguages(
            List.of(
                Mockito.mock(Language.class),
                Mockito.mock(Language.class),
                Mockito.mock(Language.class)
            )
        );
        MatcherAssert.assertThat(
            languages,
            Matchers.iterableWithSize(3)
        );
    }

    /**
     * ListedLanguages can return the best match.
     */
    @Test
    public void returnsBestMatch() {
        final Language first = Mockito.mock(Language.class);
        Mockito.when(first.confidence()).thenReturn(0.5);
        final Language second = Mockito.mock(Language.class);
        Mockito.when(second.confidence()).thenReturn(0.7);
        final Language third = Mockito.mock(Language.class);
        Mockito.when(third.confidence()).thenReturn(0.4);
        final Languages languages = new ListedLanguages(
            List.of(first, second, third)
        );
        MatcherAssert.assertThat(
            languages.bestMatch(),
            Matchers.is(second)
        );
    }

}
