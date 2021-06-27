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

    /**
     * Bearer access token.
     */
    class Bearer implements AccessToken {

        /**
         * Header value.
         */
        private final String value;

        /**
         * Ctor.
         *
         * @param value Header value.
         */
        Bearer(final String value) {
            this.value = value;
        }

        @Override
        public String header() {
            return "Authorization";
        }

        @Override
        public String value() {
            return "Bearer " + this.value;
        }
    }
}
