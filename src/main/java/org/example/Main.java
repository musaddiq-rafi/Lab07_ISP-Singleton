package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();
        Scanner scanner= new Scanner(System.in);
/////// VVI : MUST WRITE TEST CASES FOR THIS FOR MARKS ///////////
        System.out.println("Enter Username: ");
        String username= scanner.nextLine();

        System.out.println("Enter Password: ");
        String password= scanner.nextLine();

        User user= userManager.authenticate(username,password);
        if(user!= null){
            System.out.println("Authenticated as "+ user.getUsertype());
            if (user instanceof Readable){
                ((Readable)user).ReadData();
            }
            if (user instanceof Writable && !(user instanceof AdminUser)) {
                ((Writable) user).writeData(user);
            }
            if (user instanceof AdminUser) {
                ((AdminUser) user).modifySetting();
            }
        } else {
            System.out.println("Invalid type of user!!!!!");
        }
        scanner.close();


    }
}