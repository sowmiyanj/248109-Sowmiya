package creational.factory;

import utils.AppLogger;
import utils.RetryUtils;

import java.util.Scanner;

public class FactoryPatternDemo {
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        int choice;
        do {
            System.out.println("\n==== Vehicle Factory Demo ====");
            System.out.println("1. Create Car");
            System.out.println("2. Create Bike");
            System.out.println("3. Create Truck");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = RetryUtils.retry(() -> {
                try {
                    return Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid input, please enter a number");
                }
            }, 3);

            try {
                switch (choice) {
                    case 1:
                        Vehicle car = VehicleFactory.getVehicle("car");
                        car.drive();
                        break;
                    case 2:
                        Vehicle bike = VehicleFactory.getVehicle("bike");
                        bike.drive();
                        break;
                    case 3:
                        Vehicle truck = VehicleFactory.getVehicle("truck");
                        truck.drive();
                        break;
                    case 4:
                        AppLogger.info("Exiting Vehicle Factory Demo.");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                AppLogger.error("Error during vehicle creation", e);
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 4);
    }
}
