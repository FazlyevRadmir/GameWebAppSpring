package com.fazlyev.service.impl;

import com.fazlyev.model.Profile;
import com.fazlyev.model.User;
import com.fazlyev.repository.UserRepository;
import com.fazlyev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    @Transactional
    @Override
    public User save(User user) {
        Profile profile = new Profile();
        profile.setUser(user);
        user.setProfile(profile);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean authenticate(User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        User foundUser = userRepository.findByUsernameAndPassword(username, password);
        return foundUser != null;
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User updatedUser) {
        userRepository.save(updatedUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
