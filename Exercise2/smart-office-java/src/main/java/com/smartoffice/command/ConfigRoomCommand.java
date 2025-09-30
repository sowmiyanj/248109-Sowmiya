package com.smartoffice.command;

import com.smartoffice.service.OfficeManager;

public class ConfigRoomCommand implements Command {
    private final OfficeManager officeManager;
    private final int roomCount;

    public ConfigRoomCommand(OfficeManager officeManager, int roomCount) {
        this.officeManager = officeManager;
        this.roomCount = roomCount;
    }

    @Override
    public void execute() {
        officeManager.configureRooms(roomCount);
    }
}
