package com.example.cart.dto;

import javax.validation.constraints.NotBlank;

public class ProductDTO {


    @NotBlank
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private double price;

    @NotBlank
    private String description;

    public ProductDTO() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
