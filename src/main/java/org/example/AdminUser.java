package org.example;

import java.io.File;

public class AdminUser extends PowerUser {
    public AdminUser(String userID, String username, String email, String password) {
        super(userID, username, email, password);
    }

    @Override
    public String getUsertype() {
        return "Admin";
    }

    public void modifySetting(String oldFileName, String newFileName){
        FileHandler fileHandler = new FileHandler();
        fileHandler.renameFile(oldFileName, newFileName);
    }

    public void updateUserDetails(String username, String updatedDetails){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/main/java/org/example/User.csv";
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
        if (userFound){
            fileHandler.updateFile(filePath, userData);
            System.out.println("User details updated successfully!");
        }
        else{
            System.out.println("User Not Found!! ");
        }
    }
}