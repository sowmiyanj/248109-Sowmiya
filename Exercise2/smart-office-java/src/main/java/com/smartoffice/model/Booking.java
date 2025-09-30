package com.smartoffice.model;

public class Booking {
    private final String startTime;
    private final int duration;

    public Booking(String startTime, int duration) {
        this.startTime = startTime;
        this.duration = duration;
    }

    // ✅ Add these getters
    public String getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Booked at " + startTime + " for " + duration + " mins";
    }
}
