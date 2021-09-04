package com.hawaso.javacampus.controllers.ideas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IdeasController {
    @GetMapping("/ideas")
    public String index(Model model) {

        model.addAttribute("title", "아이디어 관리자");

        return "views/ideas/index";
    }

    @GetMapping("/ideas/ideaForm")
    public String ideaForm() {

        return "views/ideas/ideaForm";
    }

    @GetMapping("/ideas/ideaFormProcess")
    public String ideaFormProcess(@RequestParam("idea") String idea, Model model) {

        model.addAttribute("idea", idea);

        return "views/ideas/ideaFormProcess";
    }
}
