package com.smartoffice.command;

import com.smartoffice.service.OfficeManager;

public class AddOccupantCommand implements Command {
    private final OfficeManager officeManager;
    private final int roomId;
    private final int count;

    public AddOccupantCommand(OfficeManager officeManager, int roomId, int count) {
        this.officeManager = officeManager;
        this.roomId = roomId;
        this.count = count;
    }

    @Override
    public void execute() {
        officeManager.updateOccupancy(roomId, count);
    }
}
