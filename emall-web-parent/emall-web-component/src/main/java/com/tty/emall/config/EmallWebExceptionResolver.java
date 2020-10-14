package com.tty.emall.config;

import com.tty.emall.execption.ExistUsernameException;
import com.tty.emall.execption.LoginFailedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tty
 * @create 2020-09-06-21:34
 */
@ControllerAdvice
public class EmallWebExceptionResolver {

    @ExceptionHandler(LoginFailedException.class)
    public ModelAndView resolverLoginFailedException(LoginFailedException exception,
                                                       HttpServletRequest request,
                                                       HttpServletResponse response) {

        String viewName = "/login";

        ModelAndView modelAndView = commonResolve(viewName, exception, request, response);

        return modelAndView;

    }


    @ExceptionHandler(ExistUsernameException.class)
    public ModelAndView resolverExistUsernameException(ExistUsernameException exception,
                                                       HttpServletRequest request,
                                                       HttpServletResponse response) {

        String viewName = "/register";

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
