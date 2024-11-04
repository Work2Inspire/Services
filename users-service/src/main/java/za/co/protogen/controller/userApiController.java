package za.co.protogen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.persistence.User;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/ctrl/")
public class userApiController { //9101

    private UserServiceImpl userServiceImpl;    
    @Autowired
    public userApiController(UserServiceImpl usImpl){
        this.userServiceImpl=usImpl;
    }
    
    @RequestMapping("/add_user")
    public String Add_User(@RequestParam Long Id, @RequestParam String fName, @RequestParam String lName, @RequestParam LocalDate DOB, @RequestParam String rsaId){
        User newUser = new User();
        newUser.setId(Id);
        newUser.setFirstName(fName);
        newUser.setLastName(lName);
        newUser.setDateOfBirth(DOB);
        newUser.setRsaId(rsaId);
        return userServiceImpl.addUser(newUser);
    }

    @RequestMapping("/remove_user")
    public String Remove_User(@RequestParam Long Id){
        User receivedUser = userServiceImpl.getUserById(Id);
        if(receivedUser==null){
            return "Nothing Removed: Id not found/Empty Id";
        }
        return userServiceImpl.removeUser(receivedUser);
    }

    @GetMapping("/getuser_id")
    public String getBy_id(@RequestParam Long Id){
        if(userServiceImpl.getUserById(Id)==null){
            return "Error: Id not found/Empty Id input";
        }
        return userServiceImpl.getUserById(Id).toString();
    }

    @GetMapping("/getAll_users")
    public String getAll(){
        return userServiceImpl.getAllUsers();
    }

    @RequestMapping("/update/{id}/{sWhat}/{sTo}")
    public String Add_User(@PathVariable Long id, @PathVariable String sWhat, @PathVariable String sTo){
        //sWhat options----------
        //a.id
        //b.First Name
        //c.Last Name
        //d.DOB
        //e.RSAid

        User upUser=userServiceImpl.getUserById(id);

        if (!(sWhat.length() == 1 && sWhat.charAt(0) >= 'a' && sWhat.charAt(0) <= 'e')) {
            return "Error: Option is invalid";
        }
        if (upUser==null){
            return "Error: Reservation not found";
        }
        return userServiceImpl.updateUser(upUser,sWhat,sTo);
    }

    @GetMapping("/search/{criteria}")
    public String search_User(@PathVariable String criteria){
        List<User> returnedList=userServiceImpl.searchUsers(criteria);
        StringBuilder returnString= new StringBuilder();

        if (returnedList.isEmpty()){
            return "No User match";
        }
        for (int i = 0; i < returnedList.size(); i++) {
            returnString.append(returnedList.get(i).toString()).append("<br/>");
        }
        return "Results are as follows: <br/>"+returnString;
    }



}
