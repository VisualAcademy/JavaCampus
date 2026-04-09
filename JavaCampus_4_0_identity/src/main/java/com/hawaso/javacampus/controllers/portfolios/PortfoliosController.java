package com.hawaso.javacampus.controllers.portfolios;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfoliosController {
    //@GetMapping("/portfolios")
    @GetMapping(path = { "/portfolios", "/portfolios/index" })
    public String index() {
        return "portfolios/index";
    }
}
