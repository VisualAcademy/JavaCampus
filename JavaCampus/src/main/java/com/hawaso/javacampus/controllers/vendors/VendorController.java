package com.hawaso.javacampus.controllers.vendors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    @GetMapping()
    public String vendors() {
        return "Vendors";
    }
}
