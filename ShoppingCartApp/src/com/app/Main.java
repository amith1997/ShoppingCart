package com.app;

import java.util.List;
import java.util.Scanner;
import com.data.Inventory;
import com.service.ShoppingCart;


public class Main {
    public static void main(String[] args) {
        
        Inventory inventory = new Inventory();
        ShoppingCart shoppingCart = new ShoppingCart();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. View available products");
            System.out.println("2. Search for products by name");
            System.out.println("3. Add product to shopping cart");
            System.out.println("4. View shopping cart");
            System.out.println("5. Remove product from shopping cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    List<Product> availableProducts = inventory.getAvailableProducts();
                    if (availableProducts.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        availableProducts.forEach(System.out::println);
                    }
                    break;
                case 2:
                    System.out.print("Enter name of the product to search: ");
                    String searchName = scanner.nextLine();
                    List<Product> foundProducts = inventory.searchProductsByName(searchName);
                    if (foundProducts.isEmpty()) {
                        System.out.println(searchName+" Not found.");
                    } else {
                        foundProducts.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.print("Enter product ID to add to cart: ");
                    String productId = scanner.nextLine();
                    Product productToAdd = inventory.getProductById(productId);
                    if (productToAdd != null) {
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        shoppingCart.addProductToCart(productToAdd, quantity);
                        System.out.println("Product successfully added to cart.");
                    } else {
                        System.out.println(productId+" :Invalid ID, Please select a valid product");
                    }
                    break;
                case 4:
                	System.out.println("Cart detials: ");
                    shoppingCart.viewCart();
                    break;
                case 5:
                	System.out.print("Items in the shopping cart: ");
                	shoppingCart.viewCart();
                	
                    System.out.print("Enter product ID to remove from cart: ");
                    String productIdToRemove = scanner.nextLine();
                    Product productToRemove = inventory.getProductById(productIdToRemove);
                    if (productToRemove != null) {
                        shoppingCart.removeProductFromCart(productToRemove);
                    } else {
                        System.out.println(productToRemove+"  not found in inventory.");
                    }
                    break;
                case 6:
                    double total = shoppingCart.checkout();
                    System.out.println("Checkout complete. Total amount: Rs" + total);
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    System.out.println("Thank you for shopping.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
