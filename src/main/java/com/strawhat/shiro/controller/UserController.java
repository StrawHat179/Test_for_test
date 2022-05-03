package com.strawhat.shiro.controller;

import com.strawhat.shiro.pojo.User;
import com.strawhat.shiro.service.UserService;
import com.strawhat.shiro.tools.DigestsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/2 0:11
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * Search user string.
     *
     * @return the string
     */
    @RequestMapping("/findAllUser")
    public String searchUser(Model model){
        List<User> userList=userService.findAllUser();
        model.addAttribute("userList",userList);
        return "user-list";
    }
    @RequestMapping("/queryUserByAccount/{account}")
    public String queryUserByAccount(@PathVariable("account")String account,Model model){
           User user=userService.findUser(account);
           model.addAttribute("user",user);
        return "user-edit";
    }
    /**
     * Add user view string.
     *跳转增加用户界面
     * @return the string
     */
    @RequestMapping("/addUserView")
    public String addUserView(){
     return "user-add";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public boolean addUser(User user){
        boolean rel;
        if (user.getAccount() == null || "".equals(user.getAccount())) {
            rel = false;
            return rel;
        } else {
            String entryptPassword= DigestsUtil.entryptPassword(user.getPassword(),user.getAccount());
            user.setLookpassword(user.getPassword());
            user.setPassword(entryptPassword);
            user.setSalt(user.getAccount());
            rel = userService.addtUser(user);
            return rel;
        }
    }
    /**
     * Remove user boolean.
     *删除用户
     * @param account the account
     * @return the boolean
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
   public boolean removeUser(String account){
        boolean rel=userService.deleteUser(account);
        return rel;
   }

    /**
     * Edit user boolean.
     *编辑用户
     * @param user the user
     * @return the boolean
     */
    @RequestMapping("/editUser")
    @ResponseBody
   public boolean editUser(User user){
        String entryptPassword= DigestsUtil.entryptPassword(user.getPassword(),user.getAccount());
        user.setPassword(entryptPassword);
        boolean rel1=userService.modifyUser(user);
        return rel1;
   }


}
