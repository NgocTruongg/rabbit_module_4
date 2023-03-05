package com.example.aplication_blog.service;

import com.example.aplication_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void createCategory(Category category);

}
