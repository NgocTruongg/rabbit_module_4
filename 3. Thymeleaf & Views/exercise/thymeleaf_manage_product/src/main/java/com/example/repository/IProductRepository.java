package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listProductByName(String name);


    Product getProductById(int id);

    void createProduct(Product product);

    void updateProduct(Product product);

    Product finById(int id);

    void deleteProduct(int deleteId);
}
