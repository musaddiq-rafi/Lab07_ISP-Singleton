package org.example;

public class AdminUser extends PowerUser {
    public AdminUser(String userID, String username, String email, String password) {
        super(userID, username, email, password);
    }



    @Override
    public String getUsertype() {
        return "Admin";
    }

    public void modifySetting(){
        System.out.println("Admin can modify system settings");
    }
}
