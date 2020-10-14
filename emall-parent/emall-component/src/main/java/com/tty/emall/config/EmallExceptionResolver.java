package com.tty.emall.config;

import com.tty.emall.expection.AccessForbiddenException;
import com.tty.emall.expection.ExistUsernameException;
import com.tty.emall.expection.LoginFailedException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author tty
 * @create 2020-09-04-9:46
 */
@ControllerAdvice
public class EmallExceptionResolver {

    @ExceptionHandler(AccessForbiddenException.class)
    public ModelAndView resolveAccessForbiddenException(AccessForbiddenException exception,
                                                      HttpServletRequest request,
                                                      HttpServletResponse response) {

        String viewName = "/admin/login";

        System.out.println("进来了");

        ModelAndView modelAndView = commonResolve(viewName, exception, request, response);


        return modelAndView;

    }


    /**
     * 用户名重复异常
     * @param exception
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(ExistUsernameException.class)
    public ModelAndView resolveExistUsernameException(ExistUsernameException exception,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) {

        String viewName = "/admin/admin_add";

        ModelAndView modelAndView = commonResolve(viewName, exception, request, response);


        return modelAndView;

    }

    /**
     * 登录异常
     * @param exception
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(LoginFailedException.class)
    public ModelAndView resolveLoginFailedException(LoginFailedException exception,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) {

        System.out.println("进来了");

        String viewName = "/admin/login";

        ModelAndView modelAndView = commonResolve(viewName, exception, request, response);

        return modelAndView;

    }

    /**
     *
     * @param viewName  返回的视图名称
     * @param exception 捕捉到的异常
     * @param request   请求对象
     * @param response  响应对象
     * @return
     */
    private ModelAndView commonResolve(String viewName,
                                       Exception exception,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",exception);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

}
