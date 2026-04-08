package com.hawaso.javacampus.controllers;

import java.util.ArrayList;
import java.util.List;

import com.hawaso.javacampus.models.Phone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelpController {
    @GetMapping("/help")
    public String index(Model model) {

        var phone1 = new Phone(1, "대표", "02-114");
        var phone2 = new Phone(2, "담당", "02-119");

        List<Phone> phones = new ArrayList<>();

        phones.add(phone1);
        phones.add(phone2);

        model.addAttribute("phones", phones);

        return "help/index.html";
    }
}
