package com.ssm.base.user.controller;

import com.ssm.base.user.model.User;
import com.ssm.base.user.service.UserService;
import com.ssm.base.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public String addUser(User user){
        userService.insertUser(user);
        return JsonUtil.success();
    }

    @RequestMapping("/getUserList")
    public String getUserList(){
       return JsonUtil.success(userService.getUserList());
    }

    @RequestMapping("/selectUserById")
    public String  selectUserById(String uid){
        return JsonUtil.success(userService.selectUserById(Integer.parseInt(uid)));
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return JsonUtil.success();
    }

    @RequestMapping("/deleteUser")
    public String  deleteUser(Integer uid){
        userService.deleteUser(uid);
        return JsonUtil.success();
    }

    @RequestMapping("/getUserCondition")
    public String getUserCondition(User user){
        List<User> userCondition = userService.getUserCondition(user);
        return JsonUtil.success(userCondition);
    }

}
