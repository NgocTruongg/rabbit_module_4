package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/add")
    public String showForm (){
        return "/sandwichCondiment";
    }

    @PostMapping("/add")
    public String add(@RequestParam("condiment") String condiment, Model model) {
        model.addAttribute("listCondiment", condiment);
        return "/sandwichCondiment";
    }
}
