package com.tty.emall.interceptor;

import com.tty.emall.entity.Admin;
import com.tty.emall.expection.AccessForbiddenException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author tty
 * @create 2020-09-04-10:46
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();

        Admin admin = (Admin) httpSession.getAttribute("admin_session");

        System.out.println(admin);
        if (admin == null) {
            throw new AccessForbiddenException("请先登录！");
        }

        return true;
    }
}
