package creational.factory;

import utils.AppLogger;

public class Truck implements Vehicle {
    @Override
    public void drive() {
        AppLogger.info("Driving a truck 🚚");
        System.out.println("Driving a truck 🚚");
    }
}
