package com.dencofamily.popeyes.punch.controller;

import com.dencofamily.popeyes.punch.model.PopeyesEmpPunchData;
import com.dencofamily.popeyes.punch.repository.PopeyesEmpPunchDataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/admin"})
public class PopeyesEmpPunchDataController {

    @Autowired
    private PopeyesEmpPunchDataDAO punchDataDAO;

    /**
     * Handles the request to view all punch data.
     * @param model Model to pass data to the view
     * @return View name
     */
    @GetMapping("/popeyes-punch")
    public String viewPunchData(Model model) {
        List<PopeyesEmpPunchData> punchDataList = punchDataDAO.fetchAllPunchData();
        model.addAttribute("punchDataList", punchDataList);
        model.addAttribute("activePage", "popeyes-punch");
        return "popeyes_punch_data_view";
    }
}
