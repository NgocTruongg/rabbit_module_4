package com.example.aplication_blog.controller;


import com.example.aplication_blog.model.Blogs;
import com.example.aplication_blog.service.IBlogService;
import com.example.aplication_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showBlogList(@RequestParam(required = false, defaultValue = "") String name, Model model,
                               @PageableDefault(size = 2) Pageable pageable) {
        if (name == null) {
            name = "";
        }
        Sort sort = Sort.by("id").descending();
        Pageable sortPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Blogs> blogsPage = blogService.findAll(name, sortPageable);
        model.addAttribute("blogList", blogsPage);
        model.addAttribute("name", name);

        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <blogsPage.getTotalPages() ; i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "list";
    }
    @GetMapping("/create")
    public String showCreateForm(@RequestParam(required = false)String name,  Model model,
                                 @PageableDefault Pageable pageable){
        model.addAttribute("categoryList",categoryService.findAll(name, pageable));
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

    @GetMapping("/delete")
    public String performDelete(@RequestParam Integer deleteId){
        blogService.deleteBlog(deleteId);
        return "redirect:/blogs";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam(required = false) Integer id, Model model,String name,
                               @PageableDefault Pageable pageable){
        model.addAttribute("categoryList", categoryService.findAll(name, pageable));
        model.addAttribute("blog", blogService.findBlogById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String performUpdate(@ModelAttribute Blogs blogs) {
        blogService.updateBlog(blogs);
        return "redirect:/blogs";
    }
}
