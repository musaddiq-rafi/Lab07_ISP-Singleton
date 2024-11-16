package org.example;

public class PowerUser extends RegularUser implements Writable {

    public PowerUser(String userID, String username, String email, String password) {
        super(userID, username, email, password);
    }

    @Override
    public void writeData(String newUserDetails) {
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/main/java/org/example/User.csv"; // Path to the user data file

        fileHandler.writeFile(filePath, newUserDetails, true); // Appends new user data to the file
        System.out.println("New user details added successfully!");
    }

    @Override
    public String getUsertype() {
        return "Power";
    }
}