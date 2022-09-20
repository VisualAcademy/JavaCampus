package com.hawaso.javacampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hawaso.javacampus.models.Document;

@Controller
public class DocumentController {
    @ResponseBody
    @GetMapping("/document")
    public Document index() {
        return new Document(1234, "my document");
    }
}
