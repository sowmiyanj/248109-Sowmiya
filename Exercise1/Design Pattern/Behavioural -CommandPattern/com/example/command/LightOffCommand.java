package com.example.command;

import com.example.Light;
import com.example.utils.AppLogger;

import java.util.Objects;
import java.util.logging.Logger;

public class LightOffCommand implements Command {
    private static final Logger logger = AppLogger.getLogger();
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = Objects.requireNonNull(light, "Light cannot be null");
    }

    @Override
    public void execute() {
        logger.info("Executing LightOffCommand");
        light.turnOff();
    }
}
