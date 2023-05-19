package com.fazlyev.controller;

import com.fazlyev.model.Roles;
import com.fazlyev.model.User;
import com.fazlyev.service.UserEditService;
import com.fazlyev.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final UserEditService userEditService;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserService userService, UserEditService userEditService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userEditService = userEditService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String userList(Model model) {
        User currentUser = userService.getCurrentUser();
        System.out.println("Current User: " + currentUser.getUsername());
        Set<Roles> roles = currentUser.getRoles();
        System.out.println("User Roles:");
        for (Roles role : roles) {
            System.out.println(role.getName());
        }

        List<User> users = userEditService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "adminPage";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "adminCreateUser";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userEditService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        User user = userEditService.getUserById(id);
        model.addAttribute("user", user);
        return "adminEditUser";
    }

    @PostMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        userEditService.updateUser(id, user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/delete")
    public String deleteUserForm(@PathVariable("id") Long id, Model model) {
        User user = userEditService.getUserById(id);
        model.addAttribute("user", user);
        return "adminDeleteUser";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userEditService.deleteUser(id);
        return "redirect:/admin";
    }
}
