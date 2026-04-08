package com.hawaso.javacampus.controllers.supports;

import java.util.ArrayList;
import java.util.List;

import com.hawaso.javacampus.models.supports.FaqItem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FaqController {
    @GetMapping("/faq")
    public String faq(Model model) {

        List<FaqItem> faqs = new ArrayList<>();
        faqs.add(new FaqItem(1, "제목1", "내용1"));
        faqs.add(new FaqItem(2, "제목2", "내용2"));
        faqs.add(new FaqItem(3, "제목3", "내용3"));

        model.addAttribute("faqs", faqs);

        return "views/supports/faq";
    }
}
