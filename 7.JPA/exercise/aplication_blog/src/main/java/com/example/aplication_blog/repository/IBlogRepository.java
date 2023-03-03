package com.example.aplication_blog.repository;

import com.example.aplication_blog.model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blogs, Integer> {

    List<Blogs> findByNameContaining(String name);

}
