package com.ssm.base.user.service;

import com.ssm.base.user.model.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);
    List<User> getUserList();
    void updateUser(User user);
    User  selectUserById(Integer id);
    void deleteUser(Integer id);
    List<User> getUserCondition(User user);
}

