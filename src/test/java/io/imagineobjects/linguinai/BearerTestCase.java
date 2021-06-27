package io.imagineobjects.linguinai;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Unit tests for {@link io.imagineobjects.linguinai.AccessToken.Bearer}.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class BearerTestCase {

    /**
     * Bearer can return the Authorization header.
     */
    @Test
    public void returnsAuthorizationHeader() {
        MatcherAssert.assertThat(
            new AccessToken.Bearer("token123").header(),
            Matchers.equalTo("Authorization")
        );
    }

    /**
     * Bearer can return the bearer value.
     */
    @Test
    public void returnsBearerValue() {
        MatcherAssert.assertThat(
            new AccessToken.Bearer("token123").value(),
            Matchers.equalTo("Bearer token123")
        );
    }

}
