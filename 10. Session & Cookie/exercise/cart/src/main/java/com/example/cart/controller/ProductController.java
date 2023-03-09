package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("cart")
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("showList", iProductService.findAll());
        return "/list";
    }

}
