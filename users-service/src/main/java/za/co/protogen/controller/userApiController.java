package za.co.protogen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/ctrl/")
public class userApiController {

    @Autowired
    private RestTemplate restTemplate;
    UserService userService = new UserServiceImpl();

    @RequestMapping("/add_user")
    public String Add_User(@RequestParam Long Id, @RequestParam String fName, @RequestParam String lName, @RequestParam LocalDate DOB, @RequestParam String rsaId){
        User newUser = new User();
        newUser.setId(Id);
        newUser.setFirstName(fName);
        newUser.setLastName(lName);
        newUser.setDateOfBirth(DOB);
        newUser.setRsaId(rsaId);
        return userService.addUser(newUser);
    }

    @RequestMapping("/remove_user")
    public String Remove_User(@RequestParam Long Id){
        if(userService.getUserById(Id)==null){
            return "Nothing Removed: Id not found/Empty Id";
        }
        return userService.removeUser(userService.getUserById(Id));
    }

    @GetMapping("/getuser_id")
    public String getBy_id(@RequestParam Long Id){
        if(userService.getUserById(Id)==null){
            return "Id not found/Empty Id";
        }
        return userService.getUserById(Id).toString();
    }

    @GetMapping("/getAll_users")
    public String getAll(){
        String returnString="";
        for (int i = 0; i < userService.getAllUsers().size(); i++) {
            returnString+=userService.getAllUsers().get(i).toString()+"<br/>";
        }
        return returnString;
    }

    @RequestMapping("/update/{id}/{sWhat}/{sTo}")
    public String Add_User(@PathVariable Long id, @PathVariable String sWhat, @PathVariable String sTo){
        //sWhat options----------
        //a.id
        //b.First Name
        //c.Last Name
        //d.DOB
        //e.RSAid

        User upUser=userService.getUserById(id);

        if (!(sWhat.length() == 1 && sWhat.charAt(0) >= 'a' && sWhat.charAt(0) <= 'k')) {
            return "Error: Option is invalid";
        }
        if (upUser==null){
            return "Error: Reservation not found";
        }

        return userService.updateUser(upUser,sWhat,sTo);
    }

    @GetMapping("/search/{criteria}")
    public String search_User(@PathVariable String criteria){
        List<User> returnedList=userService.searchUsers(criteria);
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
