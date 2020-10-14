package com.tty.emall.service.api;

import com.tty.emall.entity.User;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-03-18:49
 */
public interface UserService {
    List<User> getUserByList();

    void saveUser(User user);

    boolean checkUsername(User user);

    User getUserById(Integer id);

    void resetPassword(String password, Integer id);

    void editUser(User user);

    void removeUserById(Integer id);
}
