package com.example.aplication_blog.service.Impl;

import com.example.aplication_blog.model.Category;
import com.example.aplication_blog.repository.ICategoryRepository;
import com.example.aplication_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(String name, Pageable pageable) {
      return categoryRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}
