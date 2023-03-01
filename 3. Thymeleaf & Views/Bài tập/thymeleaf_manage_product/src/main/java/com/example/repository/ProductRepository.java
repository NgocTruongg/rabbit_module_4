package com.example.repository;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private static List<Product> productList;

    static {
        productList = new ArrayList<Product>() {{
            add(new Product(1, "Rolex", "1ty5", "1851"));
            add(new Product(2, "Patek Philippe", "2ty", "1851"));
            add(new Product(3, "Audemars Piguet", "3ty", "1875"));
            add(new Product(4, "Vacheron Constantin", "1ty6", "1775"));
        }};
    }

    @Override
    public List<Product> listProductByName(String name) {
        if (name == null) {
            return productList;
        }
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        for(Product product:productList) {
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void createProduct(Product product) {
        product.setId(productList.size() +1);
        productList.add(product);
    }
}


