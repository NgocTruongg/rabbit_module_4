package com.example.aplication_blog.controller;

import com.example.aplication_blog.model.Category;
import com.example.aplication_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showCategoryList(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "category-list";
    }
    @GetMapping("create")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category-creation";
    }
    @PostMapping("create")
    public String performCategory(@ModelAttribute Category category) {
        categoryService.createCategory(category);
        return "redirect:/blogs";
    }
}
