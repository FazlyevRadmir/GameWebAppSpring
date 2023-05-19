package com.fazlyev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/homePage")
    public String showHomePage() {
        return "homePage";
    }
}
