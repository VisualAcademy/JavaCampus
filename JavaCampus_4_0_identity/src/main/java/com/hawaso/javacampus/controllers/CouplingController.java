package com.hawaso.javacampus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouplingController {
    private CouplingService service = new CouplingService();
    @GetMapping("/coupling")
    public String welcome() {
        return "Coupling: " + service.getMessage();
    }
}

class CouplingService {
    public String getMessage() {
        return "Coupling from Service";
    }
}
