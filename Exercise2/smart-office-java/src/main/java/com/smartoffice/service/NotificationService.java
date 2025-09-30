package com.smartoffice.service;

import com.smartoffice.util.LoggerUtil;

public class NotificationService {
    public static void notifyUser(String message) {
        LoggerUtil.info("NOTIFICATION: " + message);
    }
}
