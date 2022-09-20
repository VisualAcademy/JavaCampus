package com.hawaso.javacampus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hawaso.javacampus.models.Document;

@RestController
public class DocumentController {
    @GetMapping("/document")
    public Document get() {
        return new Document(1234, "my document");
    }
    @PostMapping("/document")
    public Document post(@RequestBody Document document) {

        document.setContent(document.getContent() + " saved.");

        return document; 
    }
}
// @Controller
// public class DocumentController {
//     @ResponseBody
//     @GetMapping("/document")
//     public Document index() {
//         return new Document(1234, "my document");
//     }
// }
