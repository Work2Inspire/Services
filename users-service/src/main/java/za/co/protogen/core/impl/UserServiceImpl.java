package za.co.protogen.core.impl;

import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        Constant.users.add(user);
    }
    @Override
    public void removeUser(User user) {
        Constant.users.remove(user);
    }
    @Override
    public User getUserById(String id) {
        long longId=Long.parseLong(id);
        return Constant.users.stream().filter(a->a.getId()==longId).findFirst().orElse(null);
    }
    @Override
    public List<User> getAllUsers() {
        return Constant.users;
    }
    @Override
    public void updateUser(User user,String ansUpdateWhat,String ansUpdateTo) {
        User UserUpdate = user;
        Constant.users.removeIf(a->a.getId()==user.getId());
        Constant.users.add(UserUpdate);
    }
    @Override
    public List<User> searchUsers(String criteria) {
        return List.of();
    }
}
