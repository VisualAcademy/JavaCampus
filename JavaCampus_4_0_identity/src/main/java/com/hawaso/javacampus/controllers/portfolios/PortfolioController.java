package com.hawaso.javacampus.controllers.portfolios;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {
    @GetMapping(path = { "/portfolio", "/portfolio/index" })
    public String index() {
        return "portfolio/index";
    }
}
