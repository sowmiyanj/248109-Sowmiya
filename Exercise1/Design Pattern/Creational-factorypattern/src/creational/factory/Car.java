package creational.factory;

import utils.AppLogger;

public class Car implements Vehicle {
    @Override
    public void drive() {
        AppLogger.info("Driving a car 🚗");
        System.out.println("Driving a car 🚗");
    }
}
