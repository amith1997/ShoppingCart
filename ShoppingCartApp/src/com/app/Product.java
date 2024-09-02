package com.app;

public class Product {
    private String productId;
    private String productName;
    private String productCategory;
    private double price;

    public Product(String productId, String productName, String productCategory, double price) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName +
               ", Category: " + productCategory + ", Price: Rs." + price;
    }
}
