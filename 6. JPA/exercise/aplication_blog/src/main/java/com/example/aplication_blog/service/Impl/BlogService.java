package com.example.aplication_blog.service.Impl;

import com.example.aplication_blog.model.Blogs;
import com.example.aplication_blog.repository.IBlogRepository;
import com.example.aplication_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blogs> findAll(String name) {
        return blogRepository.findByAuthorNameContaining(name);
    }

    @Override
    public void createBlog(Blogs blogs) {
        blogRepository.save(blogs);
    }

    @Override
    public Blogs findBlogById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void updateBlog(Blogs blogs) {
        blogRepository.save(blogs);
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.delete(findBlogById(id));
    }
}
