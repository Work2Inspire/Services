package za.co.protogen.core;

import za.co.protogen.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    //Adds a new user to the service.
    void removeUser(User user);
    //Removes a user from the service.
    User getUserById(Long id);
    //Retrieves a user from the service based on their unique identifier.
    List<User> getAllUsers();
    //Retrieves a list of all users in the service.
    void updateUser(User user,String ansUpdateWhat,String ansUpdateTo);
    //Updates the information or attributes of a user.
    List<User> searchUsers(String criteria);
    //searchUsers(): Searches for users based on various criteria, such as first name, last name, date of birth, etc.
}


