package com.hawaso.javacampus.controllers.notices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @GetMapping(value = {"", "/index"})    
    public String index() {
        return "views/notices/index";
    }
    @GetMapping(value = "/create")    
    public String create() {
        return "views/notices/create";
    }
    @GetMapping("/details")    
    public String details() {
        return "views/notices/details";
    }
    @GetMapping("/edit")    
    public String edit() {
        return "views/notices/edit";
    }
    @GetMapping("/delete")    
    public String delete() {
        return "views/notices/delete";
    }
}
