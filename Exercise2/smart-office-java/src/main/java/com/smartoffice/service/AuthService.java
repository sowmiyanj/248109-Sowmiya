package com.smartoffice.service;

import java.util.Scanner;

public class AuthService {
    private static AuthService instance;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    private AuthService() {}

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public boolean authenticate(Scanner scanner) {
        System.out.print("Enter username: ");
        String user = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String pass = scanner.nextLine().trim();

        return USERNAME.equals(user) && PASSWORD.equals(pass);
    }
}
