package com.smartoffice.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final int id;
    private int capacity;
    private int occupants;
    private Booking booking;
    private final List<Observer> observers = new ArrayList<>();

    public Room(int id) {
        this.id = id;
        this.capacity = 0;
        this.occupants = 0;
    }

    public int getId() {
        return id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setOccupants(int count) {
        this.occupants = count;
        notifyObservers();
    }

    public int getOccupants() {
        return occupants;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(occupants > 0);
        }
    }

    public void printStatus() {
        System.out.println("Room " + id + " | Capacity: " + capacity + " | Occupants: " + occupants +
                " | " + (booking != null ? booking.toString() : "No Booking"));
    }
}
