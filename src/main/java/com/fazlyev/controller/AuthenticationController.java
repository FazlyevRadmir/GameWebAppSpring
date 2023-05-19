package com.fazlyev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.fazlyev.model.User;
import com.fazlyev.service.UserService;

@Controller
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/authentication")
        public String showAuthenticationPage() {
        return "authenticationPage";
    }

    @Transactional
    @PostMapping("/authentication")
        public String authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return "redirect:/homePage";
    }
}
