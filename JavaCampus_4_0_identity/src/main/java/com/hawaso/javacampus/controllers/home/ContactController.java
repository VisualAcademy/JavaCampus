package com.hawaso.javacampus.controllers.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping(value = "/contact")
    public String index() {
        return "views/home/contact";
    }
}
