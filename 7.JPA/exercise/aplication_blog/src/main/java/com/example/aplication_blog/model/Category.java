package com.example.aplication_blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCategory;
    @Column(name = "category_name", unique = true)
    private String nameCategory;

    @OneToMany(mappedBy = "category")
    private Set<Blogs> blogsSet;


    public Category() {
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

}
