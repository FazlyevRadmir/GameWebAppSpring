package com.fazlyev.service;

import com.fazlyev.model.User;

import java.util.List;

public interface UserEditService {
    List<User> getAllUsers();

    void createUser(User user);

    User getUserById(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
