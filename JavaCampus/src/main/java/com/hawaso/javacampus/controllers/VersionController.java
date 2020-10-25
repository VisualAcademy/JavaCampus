package com.hawaso.javacampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VersionController {
    @RequestMapping(value = "/version")
    @ResponseBody
    public String getVersion() {
        return "<h1>JavaCampus V1.0</h1>";
    }
}
