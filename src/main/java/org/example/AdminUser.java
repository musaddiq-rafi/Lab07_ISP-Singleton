package org.example;

public class AdminUser extends PowerUser {
    public AdminUser(String userId, String username, String email, String password) {
        super(userId, username, email, password);
    }

    @Override
    public String getUsertype() {
        return "Admin";
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

        fileHandler.writeFile(filePath, newUserDetails, true);
        System.out.println("New " + userType + " user details added successfully!");
    }

    public void modifySetting(String oldFileName, String newFileName) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.renameFile(oldFileName, newFileName);
    }

    public void updateUserDetails(String username, String updatedDetails) {
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/main/java/org/example/Admin.csv";
        var userData = fileHandler.readFile(filePath);
        boolean userFound = false;

        for (String[] userRow : userData) {
            if (userRow[1].equals(username)) {
                userRow[0] = updatedDetails.split(",")[0];
                userRow[2] = updatedDetails.split(",")[2];
                userRow[3] = updatedDetails.split(",")[3];
                userFound = true;
                break;
            }
        }
        if (userFound) {
            fileHandler.updateFile(filePath, userData);
            System.out.println("User details updated successfully!");
        } else {
            System.out.println("User Not Found!!");
        }
    }
}