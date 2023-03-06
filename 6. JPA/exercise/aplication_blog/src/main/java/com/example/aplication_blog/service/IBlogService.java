package com.example.aplication_blog.service;

import com.example.aplication_blog.model.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
     Page<Blogs> findAll(String name, Pageable pageable);

    void createBlog(Blogs blogs);

    Blogs findBlogById(int id);

    void updateBlog(Blogs blogs);

    void deleteBlog(int id);
}
