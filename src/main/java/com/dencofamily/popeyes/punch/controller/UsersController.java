package com.dencofamily.popeyes.punch.controller;

import com.dencofamily.popeyes.punch.config.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.dencofamily.popeyes.punch.model.Users;
import com.dencofamily.popeyes.punch.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/admin"})
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid email or password. Please try again.");
        }
        return "login";
    }

    @GetMapping("/register")
    public String register() {return "register";}

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Users users, Model model) {
        if (usersService.registerUser(users)) {
            model.addAttribute("message", "Registration successful! You can now log in.");
            return "login";
        } else {
            model.addAttribute("error", "Registration failed. Try again.");
            return "register";
        }
    }

//    @ModelAttribute
//    public void addUserToModel(Model model, @AuthenticationPrincipal UserPrincipal user) {
//        if (user != null) {
//            model.addAttribute("loggedInUser", user.getFullName()); // Use full name instead of email
//        }
//    }


    @GetMapping("/debug-user")
    @ResponseBody
    public String debugUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return "Authenticated User: " + auth.getName();
        }
        return "No user is logged in.";
    }

    @ModelAttribute
    public void addUserToModel(Model model, @AuthenticationPrincipal UserPrincipal user) {
        if (user != null) {
            model.addAttribute("loggedInUser", user.getUsername()); //  This should set the username in model
        }
    }

    // Show profile of logged-in user
    @GetMapping("/profile")
    public String viewProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        Users user = usersService.findByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }

}
