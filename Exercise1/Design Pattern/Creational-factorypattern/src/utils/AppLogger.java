package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class AppLogger {
    private static PrintWriter writer;

    static {
        try {
            writer = new PrintWriter(new FileWriter("app.log", true), true);
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }

    private static void log(String level, String message) {
        String logEntry = LocalDateTime.now() + " [" + level + "] " + message;
        System.out.println(logEntry);
        if (writer != null) {
            writer.println(logEntry);
        }
    }

    public static void info(String message) {
        log("INFO", message);
    }

    public static void error(String message, Exception e) {
        log("ERROR", message + " | " + e.getMessage());
    }
}
