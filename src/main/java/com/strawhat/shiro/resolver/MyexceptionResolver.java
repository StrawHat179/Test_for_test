package com.strawhat.shiro.resolver;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :StrawHat
 * @date : 2022/5/1 19:22
 */
@Component
public class MyexceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView("/templates/login.html");
        if (ex instanceof UnknownAccountException || ex instanceof IncorrectCredentialsException){
            String str="111222";
            mv.setViewName("forward:/templates/login.html");
            mv.addObject("msg0",str);
            request.setAttribute("msg0",str);
            System.out.println(ex);
        }

        return mv;
    }
}
