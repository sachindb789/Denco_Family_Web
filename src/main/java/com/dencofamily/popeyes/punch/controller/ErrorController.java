package com.dencofamily.popeyes.punch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @GetMapping("/admin/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute("javax.servlet.error.status_code");
        model.addAttribute("errorMessage", "Oops! An unexpected error occurred. Please try again.");

        if (status != null) {
            model.addAttribute("errorCode", status.toString());
        } else {
            model.addAttribute("errorCode", "Unknown");
        }

        return "error-page"; // Show error-page.html
    }
}

