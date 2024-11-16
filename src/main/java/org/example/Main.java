// src/main/java/org/example/Main.java
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();

        System.out.println("Enter Password: ");
        String password = scanner.nextLine();

        User user = userManager.authenticate(username, password);
        if (user != null) {
            System.out.println("Authenticated as " + user.getUsertype());
            if (user instanceof Readable) {
                ((Readable) user).ReadData();
            }
            if (user instanceof Writable && !(user instanceof AdminUser)) {
                ((Writable) user).writeData("someDetails");
            }
            if (user instanceof AdminUser) {
                ((AdminUser) user).modifySetting("src/main/java/org/example/oldFileName.txt", "src/main/java/org/example/newFileName.txt");
            }
        } else {
            System.out.println("Invalid type of user!!!!!");
        }
        scanner.close();
    }

    private static void handleUserActions(User user) {
        if (user instanceof RegularUser) {
            handleRegularUser((RegularUser) user);
        } else if (user instanceof PowerUser) {
            handlePowerUser((PowerUser) user);
        } else if (user instanceof AdminUser) {
            handleAdminUser((AdminUser) user);
        }
    }

    private static void handleRegularUser(RegularUser user) {
        System.out.println("Regular User Menu:");
        System.out.println("1. Read Data");
        user.ReadData();
    }

    private static void handlePowerUser(PowerUser user) {
        System.out.println("Power User Menu:");
        System.out.println("1. Read Data");
        System.out.println("2. Add New User");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> user.ReadData();
            case 2 -> {
                System.out.println("Enter New User details");
                String newUserDetails = scanner.nextLine();
                user.writeData(newUserDetails);
            }
            default -> System.out.println("Invalid option!");
        }
    }

    private static void handleAdminUser(AdminUser user) {
        System.out.println("Admin User Menu:");
        System.out.println("1. Read Data");
        System.out.println("2. Add New User");
        System.out.println("3. Rename File");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> user.ReadData();
            case 2 -> {
                System.out.println("Enter new user details (comma-separated: name,username,password,usertype):");
                String newUserDetails = scanner.nextLine();
                user.writeData(newUserDetails);
            }
            case 3 -> {
                System.out.println("Enter old file name:");
                String oldFileName = scanner.nextLine();
                System.out.println("Enter new file name:");
                String newFileName = scanner.nextLine();
                user.modifySetting(oldFileName, newFileName);
            }
            default -> System.out.println("Invalid option!");
        }
    }
}