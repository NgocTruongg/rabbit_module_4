package com.example.cart.model;

import com.example.cart.dto.ProductDTO;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<ProductDTO, Integer> products = new HashMap<>();

    public Cart() {

    }

    public Cart(Map<ProductDTO, Integer> products) {
        this.products = products;
    }

    public Map<ProductDTO, Integer> getProducts() {
        return products;
    }

    //    Phương thức checkIntemInCart() để kiểm tra xem sản phẩm đó đã có trong giỏ hàng hay chưa
    private boolean checkItemInCart(ProductDTO product) {
        for (Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) ;
            return true;
        }
        return false;
    }

    private Map.Entry<ProductDTO, Integer> selectItemInCart(ProductDTO productDTO) {
        for (Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(productDTO.getId())) ;
            return entry;
        }
        return null;
    }

    // Phương thức addProduct() được sử dụng để thêm sản phẩm vào trong giỏ hàng.
    public void addProduct(ProductDTO productDTO) {
        if (!checkItemInCart(productDTO)) {
            products.put(productDTO, 1);
        } else {
            Map.Entry<ProductDTO, Integer> itemEntry = selectItemInCart(productDTO);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    //    Phương thức countProductQuantity() dùng để đếm số lượng sản phẩm đó hiện có trong giỏ hàng.
    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    //    Phương thức countItemQuantity() để đếm số lượng sản phẩm có trong giỏ hàng.
    public Integer countItemQuantity() {
        return products.size();
    }

    //   phương thức countTotalPayment() dùng để tính tổng số tiền cần phải thanh toán.
    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

}
