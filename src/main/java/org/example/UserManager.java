package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private static UserManager instance;
    private final Map<String, RegularUser> regularUsers = new HashMap<>();
    private final Map<String, PowerUser> powerUsers = new HashMap<>();
    private final Map<String, AdminUser> admins = new HashMap<>();
    private final FileHandler fileHandler = new FileHandler();

    private UserManager() {
        loadRegularUsers();
        loadPowerUsers();
        loadAdmins();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    private void loadRegularUsers() {
        List<String[]> userData = fileHandler.readFile("src/main/java/org/example/RegularUser.csv");
        for (String[] data : userData) {
            if (data.length == 4) { // Ensure data has all required fields
                regularUsers.put(data[1], new RegularUser(data[0], data[1], data[2], data[3]));
            }
        }
    }

    private void loadPowerUsers() {
        List<String[]> userData = fileHandler.readFile("src/main/java/org/example/PowerUser.csv");
        for (String[] data : userData) {
            if (data.length == 4) {
                powerUsers.put(data[1], new PowerUser(data[0], data[1], data[2], data[3]));
            }
        }
    }

    private void loadAdmins() {
        List<String[]> adminData = fileHandler.readFile("src/main/java/org/example/Admin.csv");
        for (String[] data : adminData) {
            if (data.length == 4) {
                admins.put(data[1], new AdminUser(data[0], data[1], data[2], data[3]));
            }
        }
    }

    public User authenticate(String username, String password) {
        // Check Regular Users
        if (regularUsers.containsKey(username) && regularUsers.get(username).getPassword().equals(password)) {
            return regularUsers.get(username);
        }

        // Check Power Users
        if (powerUsers.containsKey(username) && powerUsers.get(username).getPassword().equals(password)) {
            return powerUsers.get(username);
        }

        // Check Admins
        if (admins.containsKey(username) && admins.get(username).getPassword().equals(password)) {
            return admins.get(username);
        }

        // If no match is found
        return null;
    }
}