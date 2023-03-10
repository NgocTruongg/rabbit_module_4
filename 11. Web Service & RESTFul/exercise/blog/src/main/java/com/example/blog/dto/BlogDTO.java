package com.example.blog.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


public class BlogDTO {


    @NotBlank
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    public BlogDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
