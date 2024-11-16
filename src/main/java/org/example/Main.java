package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Prompt for Username and Password
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Authenticate User
        User user = userManager.authenticate(username, password);
        if (user != null) {
            // Display user type
            System.out.println("Authenticated as " + user.getUsertype());

            // Dynamically handle user actions based on type
            if (user instanceof AdminUser) {
                handleAdminUserMenu((AdminUser) user);
            } else if (user instanceof PowerUser) {
                handlePowerUserMenu((PowerUser) user);
            } else if (user instanceof RegularUser) {
                handleRegularUserMenu((RegularUser) user);
            }
        } else {
            System.out.println("Invalid Username or Password!");
        }

        scanner.close();
    }

    private static void handleRegularUserMenu(RegularUser user) {
        System.out.println("Regular User: Read-only Access.");
        user.ReadData();
    }

    private static void handlePowerUserMenu(PowerUser user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Power User Menu:");
        System.out.println("1. Read Data");
        System.out.println("2. Write Data");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> user.ReadData();
            case 2 -> {
                System.out.print("Enter data to write: ");
                String data = scanner.nextLine();
                System.out.print("Enter user type (Regular/Power/Admin): ");
                String userType = scanner.nextLine();
                user.writeData(data, userType);
            }
            default -> System.out.println("Invalid option!");
        }
    }

    private static void handleAdminUserMenu(AdminUser user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Admin User Menu:");
        System.out.println("1. Read Data");
        System.out.println("2. Write Data");
        System.out.println("3. Rename File");
        System.out.println("4. Update User Details");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> user.ReadData();
            case 2 -> {
                System.out.print("Enter data to write: ");
                String data = scanner.nextLine();
                System.out.print("Enter user type (Regular/Power/Admin): ");
                String userType = scanner.nextLine();
                user.writeData(data, userType);
            }
            case 3 -> {
                System.out.print("Enter old file name: ");
                String oldFileName = scanner.nextLine();
                System.out.print("Enter new file name: ");
                String newFileName = scanner.nextLine();
                user.modifySetting(oldFileName, newFileName);
            }
            case 4 -> {
                System.out.print("Enter username to update: ");
                String username = scanner.nextLine();
                System.out.print("Enter updated details (userID,email,password): ");
                String updatedDetails = scanner.nextLine();
                user.updateUserDetails(username, updatedDetails);
            }
            default -> System.out.println("Invalid option!");
        }
    }
}