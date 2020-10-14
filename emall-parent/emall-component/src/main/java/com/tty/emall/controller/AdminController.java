package com.tty.emall.controller;

import com.tty.emall.entity.Admin;
import com.tty.emall.expection.ExistUsernameException;
import com.tty.emall.expection.LoginFailedException;
import com.tty.emall.mapper.AdminMapper;
import com.tty.emall.service.api.AdminService;
import com.tty.emall.utils.TokenProccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author tty
 * @create 2020-09-02-11:47
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 防止表单重复提交使用重定向
     * 重定向按照常规的办法无法传值，如果拼在地址看起来很丑
     * 所以用spring3.0提供的RedirectAttributes
     * @param username
     * @param password
     * @param attr
     * @param request
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes attr, HttpServletRequest request) {

        Admin login = adminService.login(username, password);
        if (StringUtils.isEmpty(login)) {
           throw new LoginFailedException("账号或密码错误！");
        }



        HttpSession session = request.getSession();
        session.setAttribute("admin_session", login);
        attr.addFlashAttribute("msg", "登录成功!");
        return "redirect:/admin/index/page";
    }

    @GetMapping("/list")
    public String getAdmin(Model model) {
        List<Admin> admins = adminService.getAdminByList();
        model.addAttribute("admins", admins);
        return "/admin/admin_list";
    }

    @GetMapping("/remove")
    public String removeAdmin(@RequestParam("id") Integer id) {
        adminService.remove(id);

        return "redirect:/admin/list";
    }

    @PostMapping("/save")
    public String saveAdmin(Admin admin, Model model) {

        boolean flag = adminService.checkUsername(admin);

        if (!flag) {
           throw new ExistUsernameException("用户名已存在！");
        }

        adminService.saveAdmin(admin);
        return "redirect:/admin/list";
    }

    @GetMapping("/to/reset/password")
    public String toResetAdminPassword(@RequestParam("id") Integer id, Model model) {

        Admin admin = adminService.getAdminById(id);

        model.addAttribute("admin", admin);

        return "/admin/admin_reset";
    }

    @PostMapping("/reset/password")
    public String resetAdminPassword(Admin admin, HttpServletRequest request) {

        adminService.reset(admin);

        Admin adminUser = (Admin) request.getSession().getAttribute("admin_session");

        // 如果修改的是当前登录管理员的密码，需要重新登录
        if (!StringUtils.isEmpty(adminUser) && admin.getId().equals(adminUser.getId())) {
            request.getSession().removeAttribute("admin");
            return "redirect:/admin/login";
        }

        return "redirect:/admin/list";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("admin_session");
        return "redirect:/admin/login/page";
    }

}
