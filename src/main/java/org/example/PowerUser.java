package org.example;

public class PowerUser extends RegularUser implements Writable {
    public PowerUser(String userId, String username, String email, String password) {
        super(userId, username, email, password);
    }

    @Override
    public void writeData(String newUserDetails, String userType) {
        FileHandler fileHandler = new FileHandler();
        String filePath;

        switch (userType.toLowerCase()) {
            case "regular":
                filePath = "src/main/java/org/example/RegularUser.csv";
                break;
            case "power":
                filePath = "src/main/java/org/example/PowerUser.csv";
                break;
            case "admin":
                filePath = "src/main/java/org/example/Admin.csv";
                break;
            default:
                System.out.println("Invalid user type!");
                return;
        }

        fileHandler.writeFile(filePath, newUserDetails, true); // Appends new user data to the file
        System.out.println("New " + userType + " user details added successfully!");
    }

    @Override
    public String getUsertype() {
        return "Power";
    }
}