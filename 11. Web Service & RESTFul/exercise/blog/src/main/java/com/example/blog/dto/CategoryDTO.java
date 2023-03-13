package com.example.blog.dto;

import java.sql.Blob;
import java.util.Set;

public class CategoryDTO {

    private int id;
    private String name;

    private Set<BlogDTO> blogDTOSet;

    public CategoryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BlogDTO> getBlogDTOSet() {
        return blogDTOSet;
    }

    public void setBlogDTOSet(Set<BlogDTO> blogDTOSet) {
        this.blogDTOSet = blogDTOSet;
    }
}
