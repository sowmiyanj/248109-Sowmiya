package com.smartoffice.command;

import com.smartoffice.service.OfficeManager;

public class RoomStatusCommand implements Command {
    private final OfficeManager officeManager;
    private final int roomId;

    public RoomStatusCommand(OfficeManager officeManager, int roomId) {
        this.officeManager = officeManager;
        this.roomId = roomId;
    }

    @Override
    public void execute() {
        officeManager.checkRoomStatus(roomId);
    }
}
