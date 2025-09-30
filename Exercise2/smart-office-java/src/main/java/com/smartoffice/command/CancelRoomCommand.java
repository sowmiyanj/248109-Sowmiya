package com.smartoffice.command;

import com.smartoffice.service.OfficeManager;

public class CancelRoomCommand implements Command {
    private final OfficeManager officeManager;
    private final int roomId;

    public CancelRoomCommand(OfficeManager officeManager, int roomId) {
        this.officeManager = officeManager;
        this.roomId = roomId;
    }

    @Override
    public void execute() {
        officeManager.cancelBooking(roomId);
    }
}
