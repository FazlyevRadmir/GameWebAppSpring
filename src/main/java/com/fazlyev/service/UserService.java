package com.fazlyev.service;

import com.fazlyev.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(User user);
    boolean authenticate(User user);

    User getCurrentUser();

    void saveUser(User updatedUser);

    List<User> getAllUsers();

    User findByUsername(String username);
}

