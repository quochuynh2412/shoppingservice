package com.s3925997.asm1.repo;

import com.s3925997.asm1.product.*;
import java.util.*;;

public class ProductRepository {
    public static Map<String, Product> products;

    public void ProductRepository() {
        this.products = new HashMap<>();
    }

    public static Product searchProduct(String productName) {
        for (Product product : products.values()) {
            if (productName.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }

    public static void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public static void decreaseQuantity(String productName) {
        Product product = searchProduct(productName);
        product.setQuantityAvailable(product.getQuantityAvailable() - 1);
        products.replace(productName, product);
    }

    public static void increaseQuantity(String productName) {
        Product product = searchProduct(productName);
        product.setQuantityAvailable(product.getQuantityAvailable() + 1);
        products.replace(productName, product);
    }

}
