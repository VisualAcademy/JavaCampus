package com.hawaso.javacampus.controllers;

import java.util.ArrayList;
import java.util.List;

import com.hawaso.javacampus.models.Technology;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechListController {
    @GetMapping("/techlist")
    public String getTechList(Model model) {
        // ViewData(ViewBag)
        //[1] String
        model.addAttribute("techListTitle", "사이트에 적용된 기술 리스트"); 

        //[2] Object
        model.addAttribute("primary", new Technology(1, "Spring Boot"));
        
        //[3] Collection
        List<Technology> technologies = new ArrayList<Technology>(); 
        technologies.add(new Technology(1, "Java"));
        technologies.add(new Technology(2, "Spring Boot")); // BE
        technologies.add(new Technology(3, "JavaScript")); // FE
        model.addAttribute("technologies", technologies);

        return "techlist";
    }
}
