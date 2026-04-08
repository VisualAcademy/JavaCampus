package com.hawaso.javacampus.controllers.buffets;

import com.hawaso.javacampus.models.buffets.Broth;
import com.hawaso.javacampus.services.buffets.BrothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/broths")
public class BrothMvcController {

    @Autowired
    private BrothService brothService;

    @GetMapping
    public String getAllBroths(Model model) {
        List<Broth> broths = brothService.getAllBroths();
        model.addAttribute("broths", broths);
        return "views/buffets/broths/index";
    }

    @GetMapping("/create")
    public String createBroth(Model model) {
        model.addAttribute("broth", new Broth());
        return "views/buffets/broths/create";
    }

    @PostMapping("/create")
    public String saveBroth(Broth broth) {
        brothService.saveBroth(broth);
        return "redirect:/broths";
    }

    @GetMapping("/edit/{id}")
    public String editBroth(@PathVariable("id") int id, Model model) {
        Broth broth = brothService.getBrothById(id);
        model.addAttribute("broth", broth);
        return "views/buffets/broths/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateBroth(@PathVariable("id") int id, Broth broth) {
        brothService.saveBroth(broth);
        return "redirect:/broths";
    }

    @GetMapping("/delete/{id}")
    public String deleteBroth(@PathVariable("id") int id) {
        brothService.deleteBroth(id);
        return "redirect:/broths";
    }
}
