package za.co.protogen.core.impl;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.protogen.core.UserService;
import za.co.protogen.domain.user;
import za.co.protogen.persistence.User;
import za.co.protogen.persistence.repository.UserRepository;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    @Autowired
    public UserServiceImpl (UserRepository userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public String addUser(User user) {
//        Constant.users.add(user);
        userRepo.save(user);
        String returnString="";

        return "User added Successfully<br/><br/>";//+getAllUsers();
    }
    @Override
    public String removeUser(User user) {
//        Constant.users.remove(user);
        userRepo.delete(user);
        String returnString="";

        return "User removed Successfully<br/><br/>"+getAllUsers();
    }
    @Override
    public User getUserById(Long id) {
        long longId=id;
        return userRepo.findAll().stream().filter(a->a.getId()==longId).findFirst().orElse(null);
    }
    @Override
    public String getAllUsers() {
        String returnString="";
        for (int i = 0; i < userRepo.findAll().size(); i++) {
            returnString+=userRepo.findAll().get(i).toString()+"<br/>";
        }
        return returnString;
    }
    @Override
    public String updateUser(User user, String ansUpdateWhat, String ansUpdateTo) {
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
        userRepo.save(user);
        return "Update successful<br/>"+user;
    }
    @Override
    public List<User> searchUsers(String criteria) {
        List<String> strListOfUsers = new ArrayList<>();
        List<String> splitStringCriteria = new ArrayList<>();
        //stores the criteria split using " " as delimeter
        List<User> ListToReturn = new ArrayList<>();

        splitStringCriteria = List.of(criteria.split(" ")); // split criteria into array

        strListOfUsers=userRepo.findAll().stream().map(User::toString).toList();
        //Transform user objects from Constant.users list into List of String

        for (int i = 0; i < strListOfUsers.size(); i++) {
            int iSuccess=0; //Counts number of criteria current row passed

            for (int j = 0; j < splitStringCriteria.size(); j++) {
                if (strListOfUsers.get(i).contains(splitStringCriteria.get(j))){
                    iSuccess++;
                }
                if (iSuccess==splitStringCriteria.size()){
                    //Using their index, i, Find its User object equivalent and Add to listToReturn
                    ListToReturn.add(userRepo.findAll().get(i));
                }
            }//Cycle through split string

        }//Cycle through string list of Cars

        return ListToReturn;
    }
}
