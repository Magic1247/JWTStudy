package com.ark.jwtstudy.mapper;

import com.ark.jwtstudy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUsers();

    User getUserById(Integer userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

}
