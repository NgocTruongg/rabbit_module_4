package com.example.form_register.controller;

import com.example.form_register.repository.IUserRepository;
import com.example.form_register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("userList", iUserService.findAll());
        return "list";
    }

}
