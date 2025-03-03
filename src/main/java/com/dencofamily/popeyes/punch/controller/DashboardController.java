package com.dencofamily.popeyes.punch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin"})
public class DashboardController {

    @GetMapping("/dashboard")
    public String viewDashboard(Model model) {
        setActivePage(model, "dashboard");
        return "dashboard";
    }
    public void setActivePage(Model model, String page) {
        model.addAttribute("activePage", page);
    }
}
