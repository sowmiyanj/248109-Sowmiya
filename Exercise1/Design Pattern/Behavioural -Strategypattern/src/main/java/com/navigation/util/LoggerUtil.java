package com.navigation.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void info(String msg) {
        log("INFO", msg);
    }

    public static void error(String msg) {
        log("ERROR", msg);
    }

    private static void log(String level, String msg) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        System.out.println(timestamp + " [" + level + "] " + msg);
    }
}
