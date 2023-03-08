package com.example.form_register.controller;

import com.example.form_register.dto.UserDTO;
import com.example.form_register.model.User;
import com.example.form_register.repository.IUserRepository;
import com.example.form_register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "create";
    }
    @PostMapping("")
    public String performCreate(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        iUserService.create(user);
        redirectAttributes.addFlashAttribute("msg", "msg.createSuccess");
        return "redirect:/user";
    }
}
