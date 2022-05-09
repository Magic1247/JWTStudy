package com.ark.jwtstudy.controller;

import com.ark.jwtstudy.pojo.User;

import java.util.List;

public interface UserController {
    String test();
    List<User> getAllUsers();
    User getUserById(Integer userId);
    String addUser(User user);

    String updateUser(User user);

    String deleteUser(Integer userId);
}
