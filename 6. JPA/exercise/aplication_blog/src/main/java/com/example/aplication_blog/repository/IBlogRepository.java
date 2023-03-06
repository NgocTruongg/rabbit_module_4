package com.example.aplication_blog.repository;

import com.example.aplication_blog.model.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blogs, Integer> {
    Page<Blogs> findByAuthorNameContaining(String name, Pageable pageable);
}
