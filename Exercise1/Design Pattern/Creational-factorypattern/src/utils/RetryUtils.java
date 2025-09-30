package utils;

import java.util.function.Supplier;

public class RetryUtils {
    public static <T> T retry(Supplier<T> action, int maxAttempts) {
        int attempt = 0;
        while (attempt < maxAttempts) {
            try {
                return action.get();
            } catch (Exception e) {
                attempt++;
                AppLogger.error("Attempt " + attempt + " failed", e);
                if (attempt >= maxAttempts) {
                    throw e;
                }
            }
        }
        return null;
    }
}
