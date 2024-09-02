package com.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.app.*;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
        products.add(new Product("ID01", "HeadPhone", "Electronics", 65.00));
        products.add(new Product("ID02", "TV", "Electronics", 500.00));
        products.add(new Product("ID03", "Tablet", "Electronics", 200.00));
        products.add(new Product("ID04", "Laptop", "Electronics", 800.00));
        products.add(new Product("ID05", "Smartphone", "Electronics", 7000.00));
        products.add(new Product("ID06", "Dining Table", "Furnitures", 6000.00));
       
    }

    public List<Product> searchProductsByName(String name) {
        return products.stream()
                .filter(product -> product.getProductName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Product getProductById(String productId) {
        return products.stream()
                .filter(product -> product.getProductId().equalsIgnoreCase(productId))
                .findFirst()
                .orElse(null);
    }
    public List<Product> getAvailableProducts() {
        return new ArrayList<>(products);
    }
}
