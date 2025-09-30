package com.smartoffice;

import java.util.Scanner;

import com.smartoffice.command.CommandParser;
import com.smartoffice.service.AuthService;
import com.smartoffice.service.OfficeManager;
import com.smartoffice.util.LoggerUtil;

public class App {
    public static void main(String[] args) {
        LoggerUtil.info("=== Smart Office Facility Management Started ===");

        AuthService authService = AuthService.getInstance();
        Scanner scanner = new Scanner(System.in);

        if (!authService.authenticate(scanner)) {
            LoggerUtil.error("Authentication failed. Exiting application.");
            return;
        }

        OfficeManager officeManager = OfficeManager.getInstance();
        CommandParser parser = new CommandParser(officeManager);

        boolean running = true;
        while (running) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                running = false;
                LoggerUtil.info("Application terminated.");
            } else {
                parser.parseAndExecute(input);
            }
        }
        scanner.close();
    }
}
