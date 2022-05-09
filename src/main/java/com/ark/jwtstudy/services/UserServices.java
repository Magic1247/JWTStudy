package com.ark.jwtstudy.services;

import com.ark.jwtstudy.pojo.User;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers();
    User getUserById(Integer userId);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
}
