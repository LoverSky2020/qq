package com.tty.emall.service.impl;

import com.tty.emall.entity.User;
import com.tty.emall.entity.UserExample;
import com.tty.emall.mapper.UserMapper;
import com.tty.emall.service.api.UserService;
import com.tty.emall.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-03-18:49
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByList() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }

    @Override
    public void saveUser(User user) {
        String md5PswStr = Md5Utils.md5(user.getPassword());
        user.setPassword(md5PswStr);
        userMapper.insert(user);
    }

    @Override
    public boolean checkUsername(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0 ) {
            return false;
        }
        return true;
    }

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public void resetPassword(String password, Integer id) {

        User userById = getUserById(id);
        userById.setPassword(Md5Utils.md5(password));
        userMapper.updateByPrimaryKeySelective(userById);

    }

    @Override
    public void editUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void removeUserById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }


}
