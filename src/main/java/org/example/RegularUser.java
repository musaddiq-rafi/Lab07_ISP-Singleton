package org.example;

public class RegularUser implements User, Readable{
    private final String userID;
    private final String username;
    private final String email;
    private final String password;

    public RegularUser(String userID, String username, String email, String password) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public void ReadData() {
        System.out.println("Regular user can only read data.");
    }

    @Override
    public String getUserID() {
        return userID;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsertype() {
        return "Regular";
    }
}