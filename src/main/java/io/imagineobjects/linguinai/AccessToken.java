package io.imagineobjects.linguinai;

/**
 * API access token.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
interface AccessToken {

    /**
     * Header name.
     *
     * @return String.
     */
    String header();

    /**
     * Header value. Usually the token itself.
     *
     * @return String
     */
    String value();

}
