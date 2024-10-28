package za.co.protogen;

import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);

        //Add this new user
        System.out.println("Add car--------------------");
        User newUser = new User();
        newUser.setId(3L);
        newUser.setFirstName("Millie");
        newUser.setLastName("Doe");
        newUser.setDateOfBirth(LocalDate.of(1990, 1, 1));
        newUser.setRsaId("1234567890444");
        userService.addUser(newUser);
        System.out.println(Constant.users);
        System.out.println("User has been added successfully");
        System.out.println("There is now " + Constant.users.size() + " users\n");

        //Remove a user
        System.out.println("Search then remove a user-----------------------");
        userService.removeUser(userService.getUserById("ABC123"));
        System.out.println("User has been added successfully");
        System.out.println("There is now " + Constant.users.size() + " users\n");

        //get all users
        System.out.println("get all users----------------------------");
        System.out.println(userService.getAllUsers());
        System.out.println("All users printed\n");

        //get user by id
        System.out.println("get user by id------------------------");
        System.out.println(userService.getUserById("1234567890444"));
        System.out.println("1 user retrieved by id\n");

        //Update User------------------------------------------------------
        System.out.println("update user--------------------");
        //Enter user id to retrieve User from List
        System.out.println("Enter User id");
        String ansID = scanner.nextLine();
        User userToUpdate = userService.getUserById(ansID); //Retrieve Car to Update

        List<String> listofChoices = new ArrayList<>(); // List choices the user can Update as string

        String strChoices = "a.id: " + userToUpdate.getId() + "\n" //users choices in string
                + "b.First Name: " + userToUpdate.getFirstName() + "\n"
                + "c.Last Name: " + userToUpdate.getLastName() + "\n"
                + "d.RSAid: " + userToUpdate.getRsaID() + "\n";

        listofChoices = List.of(strChoices.split("\n")); //split choices and places into string List

        for (int i = 0; i < listofChoices.size(); i++) { //Display User update choices
            System.out.println(listofChoices.get(i));
        }
        System.out.println("Using the letters,What do you want to update? (case-sensitive)");

        String ansUpdateWhat = ""; //stores what user wants to update
        String ansUpdateTo = ""; //stores what user wants to update value to

        boolean GoodInput = false;
        while (!GoodInput) { //repeat until user inputs correctly
            ansUpdateWhat = scanner.nextLine();
            if (ansUpdateWhat.length() == 1 && ansUpdateWhat.charAt(0) >= 'a' && ansUpdateWhat.charAt(0) <= 'k') {
                GoodInput = true;
                System.out.println("Update to what?");
                ansUpdateTo = scanner.nextLine();
            }
        }
        userService.updateUser(userToUpdate, ansUpdateWhat, ansUpdateTo);

        System.out.println(userToUpdate);
        System.out.println("User updated successfully\n");


    }
}
