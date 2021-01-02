package com.hawaso.javacampus.controllers.prices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PricingController {
    @GetMapping("/prices")
    public String index() {
        return "prices/pricing";
    }
}
