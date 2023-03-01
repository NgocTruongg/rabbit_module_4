package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listProductByName(String name);


    Product getProductById(int id);

    void createProduct(Product product);
}
