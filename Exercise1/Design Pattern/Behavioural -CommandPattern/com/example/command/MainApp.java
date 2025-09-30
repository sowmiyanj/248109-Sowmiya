package com.example.command;

import com.example.Light;
import com.example.utils.AppLogger;
import com.example.utils.RetryUtils;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainApp {

    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        boolean keepRunning = true;

        logger.info("Command Pattern Application started");

        while (keepRunning) {
            printMenu();

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    logger.info("User selected: Turn ON Light");
                    try {
                        RetryUtils.retry(() -> {
                            remote.setCommand(new LightOnCommand(light));
                            remote.pressButton();
                        }, 3);
                    } catch (Exception e) {
                        System.out.println("Failed to turn on the light after retries.");
                    }
                    break;

                case "2":
                    logger.info("User selected: Turn OFF Light");
                    try {
                        RetryUtils.retry(() -> {
                            remote.setCommand(new LightOffCommand(light));
                            remote.pressButton();
                        }, 3);
                    } catch (Exception e) {
                        System.out.println("Failed to turn off the light after retries.");
                    }
                    break;

                case "0":
                    logger.info("User selected: Exit");
                    keepRunning = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    logger.warning("Invalid user input: " + input);
                    System.out.println("Invalid input. Please enter a valid option.");
            }
        }

        scanner.close();
        logger.info("Command Pattern Application terminated");
    }

    private static void printMenu() {
        System.out.println("\n===== COMMAND PATTERN MENU =====");
        System.out.println("1 - Turn ON Light");
        System.out.println("2 - Turn OFF Light");
        System.out.println("0 - Exit");
        System.out.print("Enter your choice: ");
    }
}