package com.hawaso.javacampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// start https://www.javacampus.com 사이트의 메인 페이지 
@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
    @GetMapping(value = "/blank")
    public String blank() {
        return "blank";
    }
}
