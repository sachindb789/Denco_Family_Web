package com.dencofamily.popeyes.punch.controller.denco_xenial;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class SystemServiceController {

    private String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", command);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            output.append(reader.lines().collect(Collectors.joining("\n")));
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            return "Error: " + e.getMessage();
        }
        return output.toString();
    }

    @PostMapping("/start")
    public String startService(Model model) {
        String result = executeCommand("sudo systemctl start denco_xenial");
        model.addAttribute("message", result);
        return "redirect:/admin/control";
    }

    @PostMapping("/stop")
    public String stopService(Model model) {
        String result = executeCommand("sudo systemctl stop denco_xenial");
        model.addAttribute("message", result);
        return "redirect:/admin/control";
    }

    @PostMapping("/restart")
    public String restartService(Model model) {
        String result = executeCommand("sudo systemctl restart denco_xenial");
        model.addAttribute("message", result);
        return "redirect:/admin/control";
    }

    @GetMapping("/status")
    public String checkStatus(Model model) {
        String result = executeCommand("sudo systemctl status denco_xenial | head -10");
        model.addAttribute("status", result);
        return "control-panel";
    }

    @GetMapping("/control")
    public String controlPanel(Model model) {
        String status = executeCommand("sudo systemctl status denco_xenial | head -10");
        model.addAttribute("status", status);
        return "control-panel";
    }

    @GetMapping("/logs")
    public String showLogs(Model model) {
        String logs = executeCommand("tail -n 20 /home/ubuntu/denco_xenial.log");
        model.addAttribute("logs", logs);
        return "control-panel";
    }
}


