package com.dencofamily.popeyes.punch.controller;

import com.dencofamily.popeyes.punch.repository.XenialPunchDetailsDAO;
import com.dencofamily.popeyes.punch.model.XenialPunchDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/admin"})
public class XenialPunchDetailsController {

    @Autowired
    private XenialPunchDetailsDAO xenialPunchDetailsDAO;

    @GetMapping("/xenial-punch")
    public String getPunchDetails(Model model) {
        List<XenialPunchDetails> punchDetails = xenialPunchDetailsDAO.fetchAllPunchDetails();
        model.addAttribute("punchDetails", punchDetails);
        model.addAttribute("activePage", "xenial-punch"); // Set activePage to 'xenial-punch'
        return "xenial_punch_details";
    }
}
