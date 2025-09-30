package com.example.command;

import com.example.utils.AppLogger;
import java.util.Objects;
import java.util.logging.Logger;

public class RemoteControl {
    private static final Logger logger = AppLogger.getLogger();
    private Command command;

    public void setCommand(Command command) {
        this.command = Objects.requireNonNull(command, "Command cannot be null");
        logger.info("Command set to " + command.getClass().getSimpleName());
    }

    public void pressButton() {
        if (command == null) {
            logger.warning("No command set to execute");
            System.out.println("No command set.");
            return;
        }
        try {
            command.execute();
        } catch (Exception e) {
            logger.severe("Error executing command: " + e.getMessage());
            System.out.println("Error executing command: " + e.getMessage());
        }
    }
}
