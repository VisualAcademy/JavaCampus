package com.hawaso.javacampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechListController {
    @GetMapping("/techlist")
    public String getTechList(Model model) {
        // ViewData
        model.addAttribute("techListTitle", "사이트에 적용된 기술 리스트"); 
        return "techlist";
    }
}
