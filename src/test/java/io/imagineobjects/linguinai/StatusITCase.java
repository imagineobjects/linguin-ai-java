package io.imagineobjects.linguinai;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * RestLinguinAi can return the account status.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class StatusITCase {

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
     * It can return the Status.
     */
    @Test
    public void returnsStatus() {
        final LinguinAi linguinAi = new RestLinguinAi(TOKEN);
        final Status status = linguinAi.status();
        MatcherAssert.assertThat(
            status.dailyLimit(),
            Matchers.equalTo(100)
        );
    }

}
