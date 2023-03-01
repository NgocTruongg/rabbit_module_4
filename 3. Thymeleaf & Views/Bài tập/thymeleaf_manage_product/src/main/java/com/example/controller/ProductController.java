package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("")
    private String listProduct(@RequestParam(name = "freeText", required = false) String freeText, Model model){

        model.addAttribute("products", this.productService.listProductByName(freeText));
        return "/list";
    }
    @GetMapping("{id}")
    private String listProduct(@PathVariable int id, Model model){
        model.addAttribute("products", this.productService.getProductById(id));
        return "/detail";
    }
    @GetMapping("/create")
    private String showCreateProduct(Model model){
        model.addAttribute("products", new Product());
        return "/create";
    }
    @PostMapping("/create")
    private String createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/products";
    }


}
