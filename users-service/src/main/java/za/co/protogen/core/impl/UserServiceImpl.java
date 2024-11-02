package za.co.protogen.core.impl;

import org.jvnet.hk2.annotations.Service;
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String addUser(User user) {
        Constant.users.add(user);
        String returnString="";

        for (int i = 0; i < Constant.users.size(); i++) {
            returnString+=Constant.users.get(i).toString()+"<br/>";
        }
        return "User added Successfully<br/><br/>"+returnString;
    }
    @Override
    public String removeUser(User user) {
        Constant.users.remove(user);
        String returnString="";

        for (int i = 0; i < Constant.users.size(); i++) {
            returnString+=Constant.users.get(i).toString()+"<br/>";
        }
        return "User removed Successfully<br/><br/>"+returnString;
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
    public String updateUser(User user,String ansUpdateWhat,String ansUpdateTo) {
        switch (ansUpdateWhat) {
            case "a":
                user.setId(Long.parseLong(ansUpdateTo));
                return "Update successful<br/>"+user;
            case "b":
                user.setFirstName(ansUpdateTo);
                return "Update successful<br/>"+user;
            case "c":
                user.setLastName(ansUpdateTo);
                return "Update successful<br/>"+user;
            case "d":
                user.setDateOfBirth(LocalDate.parse(ansUpdateTo));
                return "Update successful<br/>"+user;
            case "e":
                user.setRsaId(ansUpdateTo);
                return "Update successful<br/>"+user;
            default:
                return "Nothing Updated";
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
