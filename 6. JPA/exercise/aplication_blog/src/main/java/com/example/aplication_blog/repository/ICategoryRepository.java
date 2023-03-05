package com.example.aplication_blog.repository;

import com.example.aplication_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
