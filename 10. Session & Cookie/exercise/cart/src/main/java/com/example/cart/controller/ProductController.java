package com.example.cart.controller;

import com.example.cart.dto.ProductDTO;
import com.example.cart.model.Cart;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("cart")
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public String showListProduct(Model model) {
        model.addAttribute("productDTOList", iProductService.findAll());
        return "/list";
    }

    @GetMapping("detail")
    public String showDetail(@RequestParam Integer id, Model model) {
        model.addAttribute("productDTO", iProductService.findById(id));
        return "detail";
    }
    @GetMapping("/shop")
    public String showShop(Model model){
        model.addAttribute("productDTOtList" , iProductService.findAll());
        return "shop";
    }

    @GetMapping("/add")
    public String showCreateProduct(@RequestParam(required = false) Integer id,
                                    @RequestParam(required = false) String action,
                                    @ModelAttribute Cart cart) {
        ProductDTO productDTO = iProductService.findById(id);
        if (productDTO == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productDTO);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productDTO);
        return "redirect:/product";
    }
}
