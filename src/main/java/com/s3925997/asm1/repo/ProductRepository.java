package com.s3925997.asm1.repo;

import com.s3925997.asm1.product.*;
import java.util.*;

/**
 * @author <Le Trinh Quoc Huynh - s3925997>
 */
public final class ProductRepository {
    public static LinkedHashMap<String, Product> products = new LinkedHashMap<String, Product>();

    public static Product searchProduct(String productName) {
        for (Product product : products.values()) {
            if (productName.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }

    public static Product searchByIndex(int i) {
        Product[] productsArr = new Product[products.size()];
        productsArr = products.values().toArray(productsArr);
        return productsArr[i];
    }

    public static Map<String, Product> getProductsMap() {
        return products;
    }

    public static boolean addProduct(Product product) {
        if (!products.keySet().contains(product.getName())) {
            products.put(product.getName(), product);
            return true;
        } else {
            return false;
        }
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

    public static void resetRepo() {
        products = new LinkedHashMap<String, Product>();
    }
}
