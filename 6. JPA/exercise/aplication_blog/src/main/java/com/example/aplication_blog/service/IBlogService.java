package com.example.aplication_blog.service;

import com.example.aplication_blog.model.Blogs;

import java.util.List;

public interface IBlogService {
     List<Blogs> findAll(String name);

    void createBlog(Blogs blogs);

    Blogs findBlogById(int id);

    void updateBlog(Blogs blogs);

    void deleteBlog(int id);
}
