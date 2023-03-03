package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> listProductByName(String name);

    Product getProductById(int id);

    void createProduct(Product product);

    void updateProduct(Product product);

    Product finById(int id);

    void deleteProduct(int id);
}
