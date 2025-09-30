package com.smartoffice.service;

import java.util.HashMap;
import java.util.Map;

import com.smartoffice.config.OfficeConfig;
import com.smartoffice.model.Booking;
import com.smartoffice.model.Room;
import com.smartoffice.util.LoggerUtil;

public class OfficeManager {
    private static OfficeManager instance;
    private final OfficeConfig config = OfficeConfig.getInstance();
    private final Map<Integer, Room> rooms = new HashMap<>();

    private OfficeManager() {
    }

    public static OfficeManager getInstance() {
        if (instance == null) {
            instance = new OfficeManager();
        }
        return instance;
    }

    // ---------------- CONFIGURE ROOMS ----------------
    public void configureRooms(int count) {
        if (count <= 0) {
            LoggerUtil.warn("Invalid room count. Please enter a valid positive number" + count);
            return;
        }

        rooms.clear();
        for (int i = 1; i <= count; i++) {
            rooms.put(i, new Room(i));
        }

        LoggerUtil.info("Office Configured with " + count + " meeting rooms.");
        for (int i = 1; i <= count; i++) {
            System.out.println("Room " + i + ".");
        }

    }

    // ---------------- SET ROOM CAPACITY ----------------
    public void setRoomCapacity(int roomId, int capacity) {
        Room room = rooms.get(roomId);
        if (room == null) {
            LoggerUtil.error("Room " + roomId + " does not exist.");
            return;
        }
        if (capacity <= 0) {
            LoggerUtil.warn("Invalid capacity.Please enter a valid positive room number: " + capacity);
            return;
        }
        room.setCapacity(capacity);
        LoggerUtil.info("Room " + roomId + " maximum capacity set to " + capacity +".");
    }

    // ---------------- BOOK ROOM ----------------
    public void bookRoom(int roomId, String startTime, int duration) {
        Room room = rooms.get(roomId);
        if (room == null) {
            LoggerUtil.error("Invalid room number.Please enter a valid room number" + roomId);
            return;
        }
        if (room.getBooking() != null) {
            LoggerUtil.warn("Room" + + roomId + " is already booked during this time. Cannot book.");
            return;
        }
        room.setBooking(new Booking(startTime, duration));
        
        LoggerUtil.info("Room " + roomId + " booked from " + startTime + " for " + duration + " minutes.");
    }

    // ---------------- CANCEL BOOKING ----------------
    public void cancelBooking(int roomId) {
        Room room = rooms.get(roomId);
        if (room == null) {
            LoggerUtil.error("Room" + roomId+"does not exist.");
            return;
        }
        if (room.getBooking() == null) {
            LoggerUtil.warn("Room " + roomId+"is not booked.Cannot cancel booking.");
            return;
        }
        room.setBooking(null);
        LoggerUtil.info("Booking for Room " + roomId+"cancelled successfully.");
    }

    // ---------------- UPDATE OCCUPANCY ----------------
    public void updateOccupancy(int roomId, int occupants) {
        Room room = rooms.get(roomId);
        if (room == null) {
            LoggerUtil.error("Room " + roomId+"does not exist");
            return;
        }
        if (occupants < 0) {
            LoggerUtil.warn("Invalid occupants count.Please enter a valid positive number: " + occupants);
            return;
        }
        if (room.getCapacity() > 0 && occupants > room.getCapacity()) {
            LoggerUtil.error("Room " + roomId + " occupancy insufficient to mark as occupied.");
            return;
        }

        room.setOccupants(occupants);

        if (occupants >= 2) {
            LoggerUtil.info("Room " + roomId + "is now  occupied by" + occupants + " persons.AC and lights turned on.");
        } else if (occupants == 0) {
           
            LoggerUtil.info("Room " + roomId + " is now unoccupied.AC and lights turned off.");
        } else {
            LoggerUtil.warn("Room " + roomId + " occupancy insufficient to mark as occupied: " + occupants);
        }
    }

    // ---------------- CHECK ROOM STATUS ----------------
    public void checkRoomStatus(int roomId) {
        Room room = rooms.get(roomId);
        if (room == null) {
            LoggerUtil.error("Room " + roomId+"does not exist.");
            return;
        }

        
        if (room.getBooking() == null) {
            System.out.println("Room " + roomId + " is not booked.");
        } else {
            System.out.println("Room " + roomId + " is booked from "
                    + room.getBooking().getStartTime()
                    + " for " + room.getBooking().getDuration() + " minutes.");
        }

        
        int occupants = room.getOccupants();
        if (occupants >= 2) {
            System.out.println("Room " + roomId + " is occupied by " + occupants + " persons. AC and lights are ON.");
        } else if (occupants == 0) {
            System.out.println("Room " + roomId + " is unoccupied. AC and lights are OFF.");
        } else {
            System.out.println("Room " + roomId + " occupancy insufficient to mark as occupied.");
        }
    }
}