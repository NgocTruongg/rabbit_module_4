package com.example.repository;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Product> listProductByName(String name) {
        if (name == null) {
            return productList;
        }
        List<Product> products = entityManager.createQuery("from Product where name like concat('%',:name,'%')")
                .setParameter("name", name).getResultList();
//        for (Product product : productList) {
//            if (product.getName().contains(name)) {
//                products.add(product);
//            }
//        }
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

    @Transactional
    @Override
    public void createProduct(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void updateProduct(Product product) {
        Product product1 = entityManager.find(Product.class, product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDateOfManufacture(product1.getDateOfManufacture());
        entityManager.merge(product1);
//        for (Product value: productList) {
//            if (product.getId() == value.getId()){
//                value.setName(product.getName());
//                value.setPrice(product.getPrice());
//                value.setDateOfManufacture(product.getDateOfManufacture());
//            }
//        }
    }

    @Override
    public Product finById(int id) {
        for (Product product: productList){
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(int id) {
        productList.remove(finById(id));
    }
}


