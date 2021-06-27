package io.imagineobjects.linguinai;

import org.junit.Assume;
import org.junit.rules.ExternalResource;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * JUnit rule which finds a free port for integration testing.
 * If no port is found, the test is skipped.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public class RandomPort extends ExternalResource {
    @Override
    public final Statement apply(
        final Statement base, final Description description
    ) {
        return new Statement() {
            @Override
            // @checkstyle IllegalThrowsCheck (1 line)
            public void evaluate() throws Throwable {
                try {
                    base.evaluate();
                } catch (final BindException ignored) {
                    Assume.assumeTrue(false);
                }
            }
        };
    }

    /**
     * Returns available port number.
     * @return Available port number
     * @throws IOException in case of IO error.
     */
    public final int port() throws IOException {
        final ServerSocket socket = new ServerSocket();
        try  {
            socket.setReuseAddress(true);
            socket.bind(
                new InetSocketAddress("localhost", 0)
            );
            return socket.getLocalPort();
        } finally {
            socket.close();
        }
    }
}
