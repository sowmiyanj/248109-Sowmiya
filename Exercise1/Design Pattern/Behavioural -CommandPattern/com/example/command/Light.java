package com.example.command;


import com.example.utils.AppLogger;
import java.util.logging.Logger;

public class Light {
    private static final Logger logger = AppLogger.getLogger();

    public void turnOn() {
        logger.info("Turning light ON");
        System.out.println("Light is ON");
    }

    public void turnOff() {
        logger.info("Turning light OFF");
        System.out.println("Light is OFF");
    }
}
