package com.example.aplication_blog.repository;

import com.example.aplication_blog.model.Blogs;
import com.example.aplication_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Page<Category> findAllByNameContaining(String name, Pageable pageable);
}
