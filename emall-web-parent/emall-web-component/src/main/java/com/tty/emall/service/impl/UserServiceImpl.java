package com.tty.emall.service.impl;

import com.tty.emall.entity.User;
import com.tty.emall.entity.UserExample;
import com.tty.emall.mapper.UserMapper;
import com.tty.emall.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-06-20:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<User> users = userMapper.selectByExample(userExample);

        if (StringUtils.isEmpty(users) || users.size() == 0) {
            return null;
        }

        return users.get(0);
    }

    @Override
    public boolean checkUsername(String name) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        List<User> users = userMapper.selectByExample(userExample);

        if (users.size() > 0) {
            return false;
        }

        return true;
    }

    @Override
    public void registerUser(User user) {

        userMapper.insert(user);

    }
}
