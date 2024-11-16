package org.example;

import java.util.List;

public class RegularUser extends User {
    public RegularUser(String userId, String username, String email, String password) {
        super(userId, username, email, password);
    }

    @Override
    public void ReadData() {
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/main/java/org/example/RegularUser.csv"; // Path to the data file

        List<String[]> data = fileHandler.readFile(filePath);
        if (data.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Data for Regular User:");
            for (String[] row : data) {
                System.out.println(String.join(", ", row));
            }
        }
    }

    @Override
    public String getUsertype() {
        return "Regular";
    }
}