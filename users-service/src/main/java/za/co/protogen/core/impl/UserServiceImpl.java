package za.co.protogen.core.impl;

import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        Constant.users.add(user);
    }
    @Override
    public void removeUser(User user) {
        Constant.users.remove(user);
//        try {
//            Constant.users.remove(user);
//            System.out.println("User has been removed successfully");
//        }
//        catch (Exception e){
//            System.out.println(e);
//            System.out.println("Something unexpected occured. Try again");
//        }

    }
    @Override
    public User getUserById(Long id) {
        long longId=id;
        return Constant.users.stream().filter(a->a.getId()==longId).findFirst().orElse(null);
    }
    @Override
    public List<User> getAllUsers() {
        return Constant.users;
    }
    @Override
    public void updateUser(User user,String ansUpdateWhat,String ansUpdateTo) {
        switch (ansUpdateWhat) {
            case "a":
                user.setId(Long.parseLong(ansUpdateTo));
                break;
            case "b":
                user.setFirstName(ansUpdateTo);
                break;
            case "c":
                user.setLastName(ansUpdateTo);
                break;
            case "d":
                user.setDateOfBirth(LocalDate.parse(ansUpdateTo));
                break;
            case "e":
                user.setRsaId(ansUpdateTo);
                break;
        }
    }
    @Override
    public List<User> searchUsers(String criteria) {
        List<String> strListOfUsers = new ArrayList<>();
        List<String> splitStringCriteria = new ArrayList<>();
        //stores the criteria split using " " as delimeter
        List<User> ListToReturn = new ArrayList<>();

        splitStringCriteria = List.of(criteria.split(" ")); // split criteria into array

        strListOfUsers=Constant.users.stream().map(User::toString).toList();
        //Transform user objects from Constant.users list into List of String

        for (int i = 0; i < strListOfUsers.size(); i++) {
            int iSuccess=0; //Counts number of criteria current row passed

            for (int j = 0; j < splitStringCriteria.size(); j++) {
                if (strListOfUsers.get(i).contains(splitStringCriteria.get(j))){
                    iSuccess++;
                }
                if (iSuccess==splitStringCriteria.size()){
                    //Using their index, i, Find its User object equivalent and Add to listToReturn
                    ListToReturn.add(Constant.users.get(i));
                }
            }//Cycle through split string

        }//Cycle through string list of Cars

        return ListToReturn;
    }
}
