package com.example.aplication_blog.service;

import com.example.aplication_blog.model.Blogs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogService implements IBlogService{

    @Override
    public List<Blogs> findByNameContaining(String name) {
        return null;
    }
}
