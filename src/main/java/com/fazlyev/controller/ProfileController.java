package com.fazlyev.controller;

import com.fazlyev.model.Profile;
import com.fazlyev.model.User;
import com.fazlyev.service.ProfileService;
import com.fazlyev.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
    private final UserService userService;
    private final ProfileService profileService;

    public ProfileController(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        User user = userService.getCurrentUser();
        Profile profile = user.getProfile();
        String city = "";
        model.addAttribute("username", user.getUsername());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("secondName", user.getSecondName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phoneNumber", user.getPhoneNumber());
        model.addAttribute("city", city);
        return "profilePage";
    }


    @PostMapping("/profile")
    public String saveProfile(@ModelAttribute User updatedUser, @RequestParam String city) {
        User currentUser = userService.getCurrentUser();
        Profile profile = currentUser.getProfile();
        currentUser.setFirstName(updatedUser.getFirstName());
        currentUser.setSecondName(updatedUser.getSecondName());
        currentUser.setEmail(updatedUser.getEmail());
        currentUser.setPhoneNumber(updatedUser.getPhoneNumber());
        if (profile == null) {
            profile = new Profile(city);
            profile.setUser(currentUser);
        } else {
            profile.setCity(city);
        }

        userService.saveUser(currentUser);
        profileService.saveProfile(profile);

        return "redirect:/profile";
    }
}