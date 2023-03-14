package com.example.blog.controller;

import com.example.blog.dto.CategoryDTO;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<CategoryDTO> getCategories(Pageable pageable) {
        return iCategoryService.findAll(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CategoryDTO getCategory (@PathVariable int id) {
        return iCategoryService.findById(id);
    }

}
