package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Page<BlogDTO> findAll(Pageable pageable);
    BlogDTO findById(int id);
}
