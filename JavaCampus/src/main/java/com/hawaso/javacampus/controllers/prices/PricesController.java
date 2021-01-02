package com.hawaso.javacampus.controllers.prices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
public class PricesController {
    @GetMapping("")
    public String get() {
        return "Pricing";
    }
}
