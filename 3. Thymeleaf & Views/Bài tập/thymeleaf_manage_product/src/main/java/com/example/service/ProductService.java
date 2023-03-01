package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;



    @Override
    public List<Product> listProductByName(String name) {
        return productRepository.listProductByName(name);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }
}
