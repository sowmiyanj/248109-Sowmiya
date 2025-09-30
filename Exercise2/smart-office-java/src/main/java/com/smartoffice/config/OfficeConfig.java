package com.smartoffice.config;

public class OfficeConfig {
    private static OfficeConfig instance;
    private int roomCount;

    private OfficeConfig() {}

    public static OfficeConfig getInstance() {
        if (instance == null) {
            instance = new OfficeConfig();
        }
        return instance;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }
}
