package com.example.utils;
import java.util.logging.Logger;

public class RetryUtils {

    private static final Logger logger = AppLogger.getLogger();

    public static void retry(Runnable action, int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                action.run();
                return;  // success
            } catch (Exception e) {
                attempts++;
                logger.warning("Attempt " + attempts + " failed: " + e.getMessage());
                if (attempts >= maxAttempts) {
                    logger.severe("Max attempts reached. Aborting operation.");
                    throw e; // rethrow exception after max retries
                }
                try {
                    Thread.sleep(1000); // backoff delay
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    logger.warning("Retry sleep interrupted.");
                }
            }
        }
    }
}