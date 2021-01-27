package com.hawaso.javacampus.controllers.demos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueDemoController {
    @GetMapping("demo/VueDemo/appDataDemo")
    public String appData() {
        return "demo/vuedemo/appDataDemo";
    }
}
