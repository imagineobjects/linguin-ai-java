package io.imagineobjects.linguinai;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

/**
 * RestLinguinAi can return the SupportedLanguages.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class SupportedLanguagesITCase {

    /**
     * Linguin.ai API Token.
     * @checkstyle StaticVariableName (5 lines)
     */
    private static String TOKEN;

    /**
     * Read the API token from maven cmd param.
     */
    @BeforeClass
    public static void init() {
        String token = System.getProperty("linguin-api-token");
        if(token == null || token.isBlank()) {
            throw new IllegalStateException(
                "Please specify the linguin-api-token parameter!"
            );
        }
        TOKEN = token;
    }

    /**
     * Can return them.
     */
    @Test
    public void returnsSupportedLanguages() {
        final LinguinAi linguinAi = new RestLinguinAi(TOKEN);
        final SupportedLanguages languages = linguinAi.languages();
        final SupportedLanguage first = languages.iterator().next();
        MatcherAssert.assertThat(
            first.code(),
            Matchers.equalTo("ab")
        );
        MatcherAssert.assertThat(
            Arrays.toString(first.englishNames()),
            Matchers.equalTo("[Abkhazian]")
        );
        MatcherAssert.assertThat(
            Arrays.toString(first.nativeNames()),
            Matchers.equalTo("[аҧсуа бызшәа, аҧсшәа]")
        );
    }

}
