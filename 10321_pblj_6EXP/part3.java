

import java.util.*;
import java.util.stream.*;


class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f, category='%s'}", name, price, category);
    }
}

public class part3 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200.00, "Electronics"),
            new Product("Smartphone", 800.00, "Electronics"),
            new Product("TV", 1500.00, "Electronics"),
            new Product("Chair", 150.00, "Furniture"),
            new Product("Desk", 300.00, "Furniture"),
            new Product("Couch", 700.00, "Furniture"),
            new Product("Apple", 1.20, "Grocery"),
            new Product("Milk", 0.99, "Grocery"),
            new Product("Cheese", 5.50, "Grocery")
        );
        
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Grouped Products by Category:");
        productsByCategory.forEach((category, items) -> {
            System.out.println(category + ":");
            items.forEach(System.out::println);
        });
        
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, productOpt) ->
            System.out.println(category + ": " + productOpt.orElse(null))
        );
        
        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage Price of All Products: " + String.format("%.2f", averagePrice));
    }
}
