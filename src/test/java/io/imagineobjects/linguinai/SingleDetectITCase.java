package io.imagineobjects.linguinai;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * RestLinguinAi can detect a single language.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class SingleDetectITCase {

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
     * It can detect English.
     */
    @Test
    public void detectsEnglish() {
        final LinguinAi linguinAi = new RestLinguinAi(TOKEN);
        MatcherAssert.assertThat(
            linguinAi.detect("What's up??").bestMatch().code(),
            Matchers.equalTo("en")
        );
    }

    /**
     * It can detect German.
     */
    @Test
    public void detectsGerman() {
        final LinguinAi linguinAi = new RestLinguinAi(TOKEN);
        MatcherAssert.assertThat(
            linguinAi.detect("Woher kommst du?").bestMatch().code(),
            Matchers.equalTo("de")
        );
    }

    /**
     * It can detect Romanian.
     */
    @Test
    public void detectsRomanian() {
        final LinguinAi linguinAi = new RestLinguinAi(TOKEN);
        MatcherAssert.assertThat(
            linguinAi.detect("Eu vin din Romania.").bestMatch().code(),
            Matchers.equalTo("ro")
        );
    }

    /**
     * It can detect French.
     */
    @Test
    public void detectsFrench() {
        final LinguinAi linguinAi = new RestLinguinAi(TOKEN);
        MatcherAssert.assertThat(
            linguinAi.detect("La langue Francaise...").bestMatch().code(),
            Matchers.equalTo("fr")
        );
    }
}
