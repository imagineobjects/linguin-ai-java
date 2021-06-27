package io.imagineobjects.linguinai;

/**
 * Linguin AI account Status.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface Status {

    /**
     * How many detections can you make daily?
     * @return Integer.
     */
    int dailyLimit();

    /**
     * How many detections were performed today?
     * @return Integer.
     */
    int detectionsToday();

    /**
     * Remaining number of detections for today.
     * @return Integer.
     */
    int remainingToday();

}
