package za.co.protogen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaServer
public class userApplication {
    public static void main(String[] args) {
        SpringApplication.run(userApplication.class,args);
    }
}

//public class Application {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("System running--------------\n");
//        String ansOpWhile="";
//        while (ansOpWhile!="f"){
//
//            System.out.println("Please select what to run (case sensitive)");
//            System.out.println("a. Add user\n" +
//                    "b. Remove user\n" +
//                    "c.Get all users\n" +
//                    "d.Get user byId\n" +
//                    "e.Update a user\n" +
//                    "f.exit");
//            String ansOption=scanner.nextLine();
//            ansOpWhile=ansOption;
//
//            switch (ansOption){
//                case "a":
//                    Add_User.main(args);
//                    break;
//                case "b":
//                    Remove_User.main(args);
//                    break;
//                case "c":
//                    GetAll_User.main(args);
//                    break;
//                case "d":
//                    GetUser_byId.main(args);
//                    break;
//                case "e":
//                    Update_User.main(args);
//                    break;
//                case "f":
//                    System.exit(0);
//                    break;
//            }
//        }
//    }
//}
//
//class Add_User {
//    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        //Add this new user
//        System.out.println("Add car--------------------");
//        User newUser = new User();
//        newUser.setId(3L);
//        newUser.setFirstName("Millie");
//        newUser.setLastName("Doe");
//        newUser.setDateOfBirth(LocalDate.of(1990, 1, 1));
//        newUser.setRsaId("1234567890444");
//        userService.addUser(newUser);
//        System.out.println(Constant.users);
//        System.out.println("User has been added successfully");
//        System.out.println("There is now " + Constant.users.size() + " users\n");
//    }
//
//}
//
//class Remove_User {
//    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        //Remove a user
//        System.out.println("Search then remove a user-----------------------");
//        System.out.println("There is " + Constant.users.size() + " users\n");
//        userService.removeUser(userService.getUserById(1L));
//        System.out.println("User has been added successfully");
//        System.out.println("There is now " + Constant.users.size() + " users\n");
//    }
//}
//
//class GetAll_User {
//    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        //get all users
//        System.out.println("get all users----------------------------");
//        System.out.println(userService.getAllUsers());
//        System.out.println("All users printed\n");
//    }
//}
//
//class GetUser_byId {
//    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        //get user by id
//        System.out.println("get user by id------------------------");
//        System.out.println(userService.getUserById(2L));
//        System.out.println("1 user retrieved by id\n");
//    }
//}
//
//class Update_User {
//    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//
//        //Update User------------------------------------------------------
//        System.out.println("update user--------------------");
//        //Enter user id to retrieve User from List
//        System.out.println("Enter User id");
//        String ansID = scanner.nextLine();
//
//        User userToUpdate = userService.getUserById(Long.parseLong(ansID));
//        //Retrieve user to Update
//
//        List<String> listofChoices = new ArrayList<>(); // List choices the user can Update as string
//
//        String strChoices = "a.id: " + userToUpdate.getId() + "\n" //users choices in string
//                + "b.First Name: " + userToUpdate.getFirstName() + "\n"
//                + "c.Last Name: " + userToUpdate.getLastName() + "\n"
//                + "d.DOB: " + userToUpdate.getDateOfBirth() + "\n"
//                + "e.RSAid: " + userToUpdate.getRsaID() + "\n";
//
//        listofChoices = List.of(strChoices.split("\n")); //split choices and places Integero string List
//
//        for (Integer i = 0; i < listofChoices.size(); i++) { //Display User update choices
//            System.out.println(listofChoices.get(i));
//        }
//        System.out.println("Using the letters,What do you want to update? (case-sensitive)");
//
//        String ansUpdateWhat = ""; //stores what user wants to update
//        String ansUpdateTo = ""; //stores what user wants to update value to
//
//        Boolean GoodInput = false;
//        while (!GoodInput) { //repeat until user inputs correctly
//            ansUpdateWhat = scanner.nextLine();
//            if (ansUpdateWhat.length() == 1 && ansUpdateWhat.charAt(0) >= 'a' && ansUpdateWhat.charAt(0) <= 'k') {
//                GoodInput = true;
//                System.out.println("Update to what?");
//                ansUpdateTo = scanner.nextLine();
//            }
//        }
//        userService.updateUser(userToUpdate, ansUpdateWhat, ansUpdateTo);
//
//        System.out.println(userToUpdate);
//        System.out.println("User updated successfully\n");
//
//    }
//}
//
//class Search_User {
//    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Search User--------------------------");
//        System.out.println("Enter any Criteria--------------------------");
//        String ansSearchCriteria = scanner.nextLine();
//        System.out.println("Returned: \n"+userService.searchUsers(ansSearchCriteria)+"\n");
//    }
//}
