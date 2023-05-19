package com.fazlyev.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object errorMessage = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        if (status != null && errorMessage != null) {
            model.addAttribute("statusCode", status);
            model.addAttribute("errorMessage", errorMessage);
        } else {
            model.addAttribute("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
            model.addAttribute("errorMessage", "Internal Server Error");
        }

        return "customErrorPage";
    }
}
