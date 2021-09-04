package com.hawaso.javacampus.controllers.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {
    //@RequestMapping("/pages")
    @GetMapping("/pages")
    public String index() {
        return "/pages/pages-index";
    }
}
