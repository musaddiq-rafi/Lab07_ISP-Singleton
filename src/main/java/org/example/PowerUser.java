package org.example;

public class PowerUser extends RegularUser implements Writable{

    public PowerUser(String userID, String username, String email, String password) {
        super(userID, username, email, password);
    }


    @Override
    public void writeData(User user) {

    }

    @Override
    public String getUsertype() {
        return "Power";
    }

}
