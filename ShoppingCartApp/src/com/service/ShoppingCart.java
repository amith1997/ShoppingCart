package com.service;

import java.util.HashMap;
import java.util.Map;
import com.app.*;

public class ShoppingCart {
    private Map<Product, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public void addProductToCart(Product product, int quantity) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + quantity);
        } else {
            cart.put(product, quantity);
        }
    }

    public void removeProductFromCart(Product product) {
        if (cart.containsKey(product)) {
            cart.remove(product);
            System.out.println(product+" removed from cart.");
        } else {
            System.out.println(product+" not found in cart.");
        }
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            cart.forEach((product, quantity) -> {
                System.out.println(product + ", Quantity: " + quantity + ", Total: Rs." + (product.getPrice() * quantity));
            });
        }
    }

    public double checkout() {
        double totalAmount = cart.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        cart.clear();
        return totalAmount;
    }
}
