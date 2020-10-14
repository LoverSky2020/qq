package com.tty.emall.service.api;

import com.tty.emall.entity.User;

/**
 * @author tty
 * @create 2020-09-06-20:55
 */
public interface UserService {

    User login(String username, String password);

    /**
     * 检查用户名是否存在
     * @param name
     * @return true:不存在 false: 存在
     */
    boolean checkUsername(String name);

    void registerUser(User user);
}
