package com.navigation;

import com.navigation.context.Navigator;
import com.navigation.strategy.*;
import com.navigation.util.LoggerUtil;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LoggerUtil.info("=== Navigation System Started ===");
        Scanner scanner = new Scanner(System.in);
        Navigator navigator = new Navigator();

        boolean running = true;

        while (running) {
            try {
                System.out.print("\nEnter Source: ");
                String source = scanner.nextLine();

                System.out.print("Enter Destination: ");
                String destination = scanner.nextLine();

                System.out.println("\nChoose Route Strategy:");
                System.out.println("1. Fastest Route");
                System.out.println("2. Shortest Route");
                System.out.println("3. Scenic Route");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        navigator.setRouteStrategy(new FastestRouteStrategy());
                        break;
                    case "2":
                        navigator.setRouteStrategy(new ShortestRouteStrategy());
                        break;
                    case "3":
                        navigator.setRouteStrategy(new ScenicRouteStrategy());
                        break;
                    case "4":
                        LoggerUtil.info("Exiting Navigation System. Goodbye!");
                        running = false;
                        continue;
                    default:
                        LoggerUtil.error("Invalid choice. Try again.");
                        continue;
                }

                navigator.buildRoute(source, destination);

            } catch (Exception e) {
                LoggerUtil.error("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
