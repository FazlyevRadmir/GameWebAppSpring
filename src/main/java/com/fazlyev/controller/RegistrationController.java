package com.fazlyev.controller;

import com.fazlyev.service.AjaxService;
import com.fazlyev.service.UserService;
import com.fazlyev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private final AjaxService ajaxService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(AjaxService ajaxService, UserService userService, PasswordEncoder passwordEncoder) {
        this.ajaxService = ajaxService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registrationPage";
    }

    @GetMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(@RequestParam("username") String username) {
        return Boolean.toString(ajaxService.checkingForTheExistenceOfUser(username));
    }

    @Transactional
    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.save(user);
        return "redirect:/authentication";
    }
}
