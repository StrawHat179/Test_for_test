package com.strawhat.shiro.controller;

import com.strawhat.shiro.pojo.User;
import com.strawhat.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :StrawHat
 * @date : 2022/5/1 19:09
 */
@Controller
public class BaseController {
    /**
     * Login string.
     *执行登录方法
     * @return the string
     */
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String login(Model model, User user){
        //shiro执行认证
        Subject subject = SecurityUtils.getSubject();
        //用token封装我们的用户名、密码
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),user.getPassword());
        String username=userService.findUsername(user.getAccount());

        //记住我的设置

        try {
            token.setRememberMe(false);
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        if(subject.isAuthenticated()==true&&user.getAccount().equals("admin")) {
            String msg1=userService.findUsername(user.getAccount());
            System.out.println(user.getAccount());
            model.addAttribute("msg",msg1);
            return "index1";
        }
        else if (subject.isAuthenticated()==true){
            model.addAttribute("username", username);
            return "index";
        }
        else {
            model.addAttribute("msg0","账号或密码错误");
            return "login";

        }
    }
}
