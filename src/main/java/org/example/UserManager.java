package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static UserManager instance;
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, AdminUser> admins = new HashMap<>();
    private final FileHandler fileHandler = new FileHandler();

    private UserManager(){
        loadUsers();
        loadAdmins();
    }

    public static UserManager getInstance(){
        if(instance == null){
            instance = new UserManager();
        }
        return instance;
    }

    private void loadUsers(){
        //inner implementations
    }

    private void loadAdmins(){
        //inner implementations
    }

    public User authenticate(){
        //inner implmentations
        return null;
    }


}
