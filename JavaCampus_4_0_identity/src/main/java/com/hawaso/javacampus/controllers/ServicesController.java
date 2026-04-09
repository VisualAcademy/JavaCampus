package com.hawaso.javacampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicesController {
    @GetMapping("/services")
    public String index() {
        return "services";
    }
}
