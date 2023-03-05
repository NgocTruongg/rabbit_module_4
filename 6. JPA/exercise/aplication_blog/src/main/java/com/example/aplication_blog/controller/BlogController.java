package com.example.aplication_blog.controller;


import com.example.aplication_blog.model.Blogs;
import com.example.aplication_blog.service.IBlogService;
import com.example.aplication_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showBlogList(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        if (name == null) {
            name = "";
        }
        model.addAttribute("blogList", blogService.findAll(name));
        return "list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("categoryList",categoryService.findAll());
        model.addAttribute("blog", new Blogs());
        return "create";
    }
    @PostMapping("/create")
    public String performCreate(@ModelAttribute Blogs blogs){
        blogService.createBlog(blogs);
        return "redirect:/blogs";
    }
    @GetMapping("/detail")
    public String showBlogDetail(@RequestParam Integer id, Model model){
        model.addAttribute("blog", blogService.findBlogById(id));
        return "detail";
    }

    @GetMapping("delete")
    public String performDelete(@RequestParam Integer deleteId){
        blogService.deleteBlog(deleteId);
        return "redirect:/blogs";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findBlogById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String performUpdate(@ModelAttribute Blogs blogs) {
        blogService.updateBlog(blogs);
        return "redirect:/edit";
    }
}
