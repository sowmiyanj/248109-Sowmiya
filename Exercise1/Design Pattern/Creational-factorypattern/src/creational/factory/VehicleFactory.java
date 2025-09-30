package creational.factory;

import utils.AppLogger;

public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Vehicle type cannot be null or empty");
        }
        switch (type.toLowerCase()) {
            case "car":
                AppLogger.info("Created a Car instance");
                return new Car();
            case "bike":
                AppLogger.info("Created a Bike instance");
                return new Bike();
            case "truck":
                AppLogger.info("Created a Truck instance");
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
