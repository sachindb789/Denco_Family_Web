package com.dencofamily.popeyes.punch.controller;

import com.dencofamily.popeyes.punch.model.XenialEEChanges;
import com.dencofamily.popeyes.punch.service.XenialEEChangesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/admin"})
public class XenialEEChangesController {

    private final XenialEEChangesService xenialEEChangesService;

    public XenialEEChangesController(XenialEEChangesService xenialEEChangesService) {
        this.xenialEEChangesService = xenialEEChangesService;
    }

    @GetMapping("/xenial-ee-changes")
    public String viewXenialEEChanges(Model model) {
        List<XenialEEChanges> changes = xenialEEChangesService.getAllChanges();

        model.addAttribute("changes", changes);
        model.addAttribute("activePage", "xenial-ee-changes"); // Mark sidebar active
        return "xenial-ee-changes"; // Thymeleaf template name
    }
}
