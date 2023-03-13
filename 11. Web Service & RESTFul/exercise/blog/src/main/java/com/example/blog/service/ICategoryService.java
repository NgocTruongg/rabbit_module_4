package com.example.blog.service;

import com.example.blog.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<CategoryDTO> findAll(Pageable pageable);
    CategoryDTO findById(int id);
}
