package com.example.save_email.controller;

import com.example.save_email.model.EmailBox;
import com.example.save_email.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("email-box")
public class EmailController {

    @Autowired
    private IEmailBoxService emailBoxService;

   @GetMapping("")
    public String showEmailForm(Model model) {
       model.addAttribute("emailBox", emailBoxService.getEmailBox());
       model.addAttribute("languageList", Arrays.asList("English", "Vietnamese", "Thai Lan", "Chinese"));
       model.addAttribute("pageSizeList", Arrays.asList("5","10", "15", "25", "50", "100"));
        return "/email";
   }
   @PostMapping("")
    public String performUpdate(@ModelAttribute EmailBox emailBox, Model model) {
       emailBoxService.updateEmailBox(emailBox);
       model.addAttribute("emailBox", emailBox);
       return "/detail";
   }

}
