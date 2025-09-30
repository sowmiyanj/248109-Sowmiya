package creational.factory;

import utils.AppLogger;

public class Bike implements Vehicle {
    @Override
    public void drive() {
        AppLogger.info("Riding a bike 🏍️");
        System.out.println("Riding a bike 🏍️");
    }
}
