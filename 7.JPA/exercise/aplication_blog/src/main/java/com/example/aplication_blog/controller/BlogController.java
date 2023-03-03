package com.example.aplication_blog.controller;

import com.example.aplication_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    private String listBlog(@RequestParam(name = "freeText", required = false) String freeText, Model model) {
        model.addAttribute("blogs", this.blogService.findByNameContaining(freeText));
        return "/list";
    }
}
