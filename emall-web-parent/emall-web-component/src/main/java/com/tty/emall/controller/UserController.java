package com.tty.emall.controller;

import com.tty.emall.entity.User;
import com.tty.emall.execption.ExistUsernameException;
import com.tty.emall.execption.LoginFailedException;
import com.tty.emall.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录/注册/退出
 * @author tty
 * @create 2020-09-06-19:24
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {

        User user = userService.login(username, password);

        if (StringUtils.isEmpty(user)) {
            throw new LoginFailedException("用户名或密码错误！");
        }

        request.getSession().setAttribute("user", user);

        return "redirect:/index/display";
    }

    @PostMapping("/register")
    public String register(User user) {

        System.out.println(user);

        boolean flag = userService.checkUsername(user.getUsername());
        if (!flag) {
            // 抛异常
            throw new ExistUsernameException("用户名已存在！");
        }
        userService.registerUser(user);
        return "/login";
    }

}
