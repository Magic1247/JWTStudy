package com.ark.jwtstudy.controller.impl;

import com.ark.jwtstudy.controller.UserController;
import com.ark.jwtstudy.pojo.User;
import com.ark.jwtstudy.services.impl.UserServicesImpl;
import com.ark.jwtstudy.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserServicesImpl userServices;

    @GetMapping("/test/test")
    @Override
    public String test() {
        return "login successful";
    }

    @GetMapping("/test/getAllUsers")
    @Override
    public List<User> getAllUsers() {
        return userServices.getAllUsers();
//        return null;
    }

    @GetMapping("/test/getUserById")
    @Override
    public User getUserById(Integer userId) {
        return userServices.getUserById(userId);
    }

    @PostMapping("/test/addUser")
    @Override
    public String addUser(@RequestBody User user) {
        try {
            userServices.addUser(user);
            return "新增成功！";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "新增失败,内部异常";
        }
    }

    @PostMapping("/test/updateUser")
    @Override
    public String updateUser(@RequestBody User user) {
        try {
            userServices.updateUser(user);
            return "更新成功！";
        } catch (Exception e) {
            return "更新失败,内部异常";

        }
    }

    @PostMapping("/test/deleteUser")
    @Override
    public String deleteUser(Integer userId) {
        try {
            userServices.deleteUser(userId);
            return "删除成功！";
        } catch (Exception e) {
            return "删除失败，内部异常";
        }

    }

    @PostMapping("user/login")
    @Override
    public Map login(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            User dbUser = userServices.login(user.getName(), user.getPassword());
            map.put("message", "登陆成功！");
            map.put("User", dbUser);
            HashMap<String, String> temp = new HashMap<>();
            temp.put("id", dbUser.getId().toString());
            temp.put("name", dbUser.getName());
            String token = JWTUtils.getToken(temp);
            map.put("token", token);
            return map;
        } catch (Exception e) {
            map.put("message", "登陆失败！账号或密码错误");
            return map;
        }
    }
}
