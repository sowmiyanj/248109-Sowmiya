package travelbuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppLogger {
    private static final Logger logger = Logger.getLogger(AppLogger.class.getName());

    private AppLogger() {}

    public static void info(String message) {
        logger.log(Level.INFO, message);
    }

    public static void error(String message, Exception e) {
        logger.log(Level.SEVERE, message, e);
    }
}
