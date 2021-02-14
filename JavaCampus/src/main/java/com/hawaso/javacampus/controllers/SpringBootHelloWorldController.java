package com.hawaso.javacampus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootHelloWorldController {
    @GetMapping("/SpringBootHelloWorld")
    public String index() {
        return "Spring Boot Hello World!";
    }
}
