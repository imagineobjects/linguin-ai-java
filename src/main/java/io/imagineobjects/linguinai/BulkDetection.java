package io.imagineobjects.linguinai;

/**
 * Result of the /bulk detection operation.
 * It's an iterable of Languages (one for corresponding for each input text).
 */
public interface BulkDetection extends Iterable<Languages> {
}
