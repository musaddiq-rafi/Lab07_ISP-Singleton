package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private static UserManager instance;
    private final Map<String, User> regularUsers = new HashMap<>();
    private final Map<String, User> powerUsers = new HashMap<>();
    private final Map<String, AdminUser> admins = new HashMap<>();
    private final FileHandler fileHandler = new FileHandler();

    private UserManager(){
        loadRegularUsers();
        loadPowerUsers();
        loadAdmins();
    }

    public static UserManager getInstance(){
        if(instance == null){
            instance = new UserManager();
        }
        return instance;
    }

    private void loadRegularUsers(){
        List <String[]> userData= fileHandler.readFile("/Users/musaddiqrafi/Desktop/codes/3rdSem/Object_Oriented_Concepts_2/Lab_07_ISP_and_Singleton/src/main/java/org/example/RegularUser.csv");
        for(String[] data:userData){
            if(data.length==4){
                User user = new RegularUser(data[0], data[1],data[2],data[3] );
                regularUsers.put(data[1],user);
            }
        }
    }
    private void loadPowerUsers(){
        List <String[]> userData= fileHandler.readFile("/Users/musaddiqrafi/Desktop/codes/3rdSem/Object_Oriented_Concepts_2/Lab_07_ISP_and_Singleton/src/main/java/org/example/PowerUser.csv");
        for(String[] data:userData){
            if(data.length==4){
                User user = new PowerUser(data[0], data[1],data[2],data[3] );
                powerUsers.put(data[1],user);
            }
        }
    }

    private void loadAdmins(){
        List <String[]> adminData= fileHandler.readFile("/Users/musaddiqrafi/Desktop/codes/3rdSem/Object_Oriented_Concepts_2/Lab_07_ISP_and_Singleton/src/main/java/org/example/Admin.csv");
        for(String[] data:adminData){
            if(data.length==4){
                AdminUser admin = new AdminUser(data[0], data[1],data[2],data[3] );
                admins.put(data[1], admin);
            }
        }

    }

    public User authenticate(String username, String password) {
        User user = regularUsers.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        user = powerUsers.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        AdminUser admin = admins.get(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }


        return null;
    }


}
