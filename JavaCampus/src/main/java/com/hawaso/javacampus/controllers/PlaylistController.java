package com.hawaso.javacampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlaylistController {
    @RequestMapping("/playlist")
    public String index() {
        return "playlist";
    }
}

