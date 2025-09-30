package com.smartoffice.command;

import com.smartoffice.service.OfficeManager;

public class BookRoomCommand implements Command {
    private final OfficeManager officeManager;
    private final int roomId;
    private final String startTime;
    private final int duration;

    public BookRoomCommand(OfficeManager officeManager, int roomId, String startTime, int duration) {
        this.officeManager = officeManager;
        this.roomId = roomId;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        officeManager.bookRoom(roomId, startTime, duration);
    }
}
