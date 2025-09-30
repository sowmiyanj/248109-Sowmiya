package com.smartoffice.command;

import com.smartoffice.service.OfficeManager;

public class ConfigRoomCapacityCommand implements Command {
    private final OfficeManager officeManager;
    private final int roomId;
    private final int capacity;

    public ConfigRoomCapacityCommand(OfficeManager officeManager, int roomId, int capacity) {
        this.officeManager = officeManager;
        this.roomId = roomId;
        this.capacity = capacity;
    }

    @Override
    public void execute() {
        officeManager.setRoomCapacity(roomId, capacity);
    }
}
