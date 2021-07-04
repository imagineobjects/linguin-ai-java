package io.imagineobjects.linguinai;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

/**
 * RestLinguinAi can detect languages in bulk.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class BulkDetectionITCase {

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
     * It can detect English, German, Romanian and French in bulk.
     */
    @Test
    public void detectsInBulk() {
        final LinguinAi linguinAi = new RestLinguinAi(TOKEN);
        final BulkDetection bulk = linguinAi.bulkDetect(
            "What's up??",
            "Woher kommst du?",
            "Eu vin din Romania.",
            "La langue Francaise..."
        );
        final Iterator<Languages> languages = bulk.iterator();
        MatcherAssert.assertThat(
            languages.next().bestMatch().code(),
            Matchers.equalTo("en")
        );
        MatcherAssert.assertThat(
            languages.next().bestMatch().code(),
            Matchers.equalTo("de")
        );
        MatcherAssert.assertThat(
            languages.next().bestMatch().code(),
            Matchers.equalTo("ro")
        );
        MatcherAssert.assertThat(
            languages.next().bestMatch().code(),
            Matchers.equalTo("fr")
        );
    }

}
