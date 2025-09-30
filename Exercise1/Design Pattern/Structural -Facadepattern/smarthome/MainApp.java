package smarthome;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHomeFacade smartHome = new SmartHomeFacade();
        int choice;

        do {
            System.out.println("\n==== Smart Home Menu ====");
            System.out.println("1. Leaving Home Mode");
            System.out.println("2. Arriving Home Mode");
            System.out.println("3. Exit");

            choice = RetryUtils.retryInput("Enter choice: ", Integer::parseInt, 3);

            switch (choice) {
                case 1 -> smartHome.leavingHome();
                case 2 -> smartHome.arrivingHome();
                case 3 -> System.out.println("Exiting Smart Home system...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        scanner.close();
    }
}
