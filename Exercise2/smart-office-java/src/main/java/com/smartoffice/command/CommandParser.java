package com.smartoffice.command;

import com.smartoffice.service.OfficeManager;
import com.smartoffice.util.LoggerUtil;

public class CommandParser {
    private final OfficeManager officeManager;

    public CommandParser(OfficeManager officeManager) {
        this.officeManager = officeManager;
    }

    public void parseAndExecute(String input) {
        try {
            String[] tokens = input.split(" ");
            String commandType = tokens[0].toLowerCase();

            Command command = null;
            switch (commandType) {
                case "config":
                    if ("count".equalsIgnoreCase(tokens[2])) {
                        command = new ConfigRoomCommand(officeManager, Integer.parseInt(tokens[3]));
                    } else if ("max".equalsIgnoreCase(tokens[2]) && "capacity".equalsIgnoreCase(tokens[3])) {
                        command = new ConfigRoomCapacityCommand(officeManager,
                                Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]));
                    }
                    break;
                case "block":
                    command = new BookRoomCommand(officeManager, Integer.parseInt(tokens[2]),
                            tokens[3], Integer.parseInt(tokens[4]));
                    break;
                case "cancel":
                    command = new CancelRoomCommand(officeManager, Integer.parseInt(tokens[2]));
                    break;
                case "add":
                    command = new AddOccupantCommand(officeManager,
                            Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;
                case "room":
                    if ("status".equalsIgnoreCase(tokens[1])) {
                        command = new RoomStatusCommand(officeManager, Integer.parseInt(tokens[2]));
                    }
                    break;
                default:
                    LoggerUtil.warn("Unknown command.");
            }
            if (command != null) command.execute();
        } catch (Exception e) {
            LoggerUtil.error("Invalid input format: " + e.getMessage());
        }
    }
}
