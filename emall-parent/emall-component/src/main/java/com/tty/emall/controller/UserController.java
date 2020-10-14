package com.tty.emall.controller;

import com.tty.emall.entity.User;
import com.tty.emall.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-03-18:48
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getUser(Model model) {
        List<User> users = userService.getUserByList();
        model.addAttribute("users", users);
        return "/admin/user_list";
    }

    @PostMapping("/save")
    public String saveUser(User user, Model model) {

        boolean flag = userService.checkUsername(user);

        if (!flag) {
            model.addAttribute("msg", "用户名已存在");
            model.addAttribute("user", user);
            return "/admin/user_add";
        }
        userService.saveUser(user);
        return "redirect:/admin/user/list";

    }

    @GetMapping("/to/reset/password")
    public String toResetPassword(@RequestParam("id") Integer id, Model model) {

        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/admin/user_reset";
    }

    @PostMapping("/reset/password")
    public String resetPassword(@RequestParam("password") String password, Model model, @RequestParam("id") Integer id) {


        userService.resetPassword(password, id);

        return  "redirect:/admin/user/list";
    }

    @GetMapping("/to/edit")
    public String toEditUser(@RequestParam("id") Integer id, Model model) {
        User userById = userService.getUserById(id);
        model.addAttribute("user", userById);
        return "/admin/user_edit";
    }

    @PostMapping("/edit")
    public String editUser(User user, Model model) {
        userService.editUser(user);
        return "redirect:/admin/user/list";
    }

    @GetMapping("/remove")
    public String removeUser(@RequestParam("id") Integer id) {
        userService.removeUserById(id);
        return "redirect:/admin/user/list";
    }

}
