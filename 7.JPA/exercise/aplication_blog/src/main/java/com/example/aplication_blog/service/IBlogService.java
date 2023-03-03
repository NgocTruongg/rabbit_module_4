package com.example.aplication_blog.service;

import com.example.aplication_blog.model.Blogs;

import java.util.List;

public interface IBlogService {

    List<Blogs> findByNameContaining(String name);
}
