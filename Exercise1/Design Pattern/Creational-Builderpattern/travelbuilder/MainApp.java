package travelbuilder;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelDirector director = new TravelDirector();
        int choice;

        do {
            System.out.println("\n==== Travel Package Builder Menu ====");
            System.out.println("1. Build Luxury Package");
            System.out.println("2. Build Budget Package");
            System.out.println("3. Build Custom Package");
            System.out.println("4. Exit");

            choice = RetryUtils.retryInput("Enter choice: ", Integer::parseInt, 3);

            try {
                switch (choice) {
                    case 1 -> {
                        TravelPackage luxury = director.buildLuxuryPackage();
                        AppLogger.info("Built: " + luxury);
                        System.out.println(luxury);
                    }
                    case 2 -> {
                        TravelPackage budget = director.buildBudgetPackage();
                        AppLogger.info("Built: " + budget);
                        System.out.println(budget);
                    }
                    case 3 -> {
                        TravelPackage custom = buildCustomPackage(scanner);
                        AppLogger.info("Built Custom: " + custom);
                        System.out.println(custom);
                    }
                    case 4 -> AppLogger.info("Exiting Travel Builder...");
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                AppLogger.error("Error during travel package build", e);
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 4);

        scanner.close();
    }

    private static TravelPackage buildCustomPackage(Scanner scanner) {
        String destination = RetryUtils.retryInput("Enter Destination: ", input -> input, 3);
        String hotel = RetryUtils.retryInput("Enter Hotel: ", input -> input, 3);
        String transport = RetryUtils.retryInput("Enter Transport: ", input -> input, 3);
        String meals = RetryUtils.retryInput("Enter Meals: ", input -> input, 3);

        return new TravelPackage.TravelPackageBuilder()
                .setDestination(destination)
                .setHotel(hotel)
                .setTransport(transport)
                .setMeals(meals)
                .build();
    }
}

