package com.hawaso.javacampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrataController {
    @GetMapping("/errata")
    public String errata() {
        return "errata";
    }
}
