package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> listProductByName(String name);

    Product getProductById(int id);

    void createProduct(Product product);
}
