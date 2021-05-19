package com.hawaso.javacampus.controllers.demos;

import com.hawaso.javacampus.models.demos.FormSubmissionDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormSubmissionDemoController {
    
    @GetMapping("/Demos/FormSubmissionDemo")
    public String formSubmissionDemo(Model model) {
        model.addAttribute("title", "폼 전송 데모");
        model.addAttribute("dto", new FormSubmissionDto());
        return "demos/FormSubmissionDemo";
    }

    @PostMapping("/Demos/FormSubmissionDemo")
    public String formSubmissionDemo(@ModelAttribute FormSubmissionDto dto, Model model) {
        model.addAttribute("dto", dto);
        return "demos/FormSubmissionDemoProcess";
    }
}
