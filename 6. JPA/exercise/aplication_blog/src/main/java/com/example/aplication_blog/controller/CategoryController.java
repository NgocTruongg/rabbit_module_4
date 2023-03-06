package com.example.aplication_blog.controller;

import com.example.aplication_blog.model.Category;
import com.example.aplication_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showCategoryList(@RequestParam(required = false) String name,Model model,
                                  @PageableDefault(size = 2) Pageable pageable) {
        if (name == null) {
            name="";
        }
        Page<Category> categoryPage = categoryService.findAll(name, pageable);
        model.addAttribute("categoryList", categoryPage);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 0; i<= categoryPage.getTotalPages();i++){
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
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
