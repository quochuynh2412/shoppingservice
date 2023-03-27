package com.s3925997.asm1.cart;

import java.util.Set;

import com.s3925997.asm1.product.PhysicalProduct;
import com.s3925997.asm1.product.Product;
import com.s3925997.asm1.repo.ProductRepository;
import com.s3925997.asm1.repo.ShoppingCartRepo;

public class ShoppingCart implements Comparable<ShoppingCart> {
    private Set<String> products;
    private double shippingBaseFee = 0.1;

    public boolean addItem(String productName) {
        Product product = ProductRepository.searchProduct(productName);
        if (product.getQuantityAvailable() == 0) {
            return false;
        } else {
            if (products.contains(productName)) {
                return false;
            } else {
                ProductRepository.decreaseQuantity(productName);
                return true;
            }
        }
    }

    public boolean removeItem(String productName) {
        Product product = ProductRepository.searchProduct(productName);
        if (products.contains(productName)) {
            return false;
        } else {
            ProductRepository.increaseQuantity(productName);
            return true;
        }
    }

    public double cartAmount() {
        double amount = 0;
        for (String productName : products) {
            Product product = ProductRepository.searchProduct(productName);
            if (product instanceof PhysicalProduct) {
                amount += ((PhysicalProduct) product).getPrice();
                amount += ((PhysicalProduct) product).getWeight() * shippingBaseFee;
            } else {
                amount += ((PhysicalProduct) product).getPrice();
            }
        }
        return amount;
    }

    public double getTotalWeight() {
        double weight = 0;
        for (String productName : products) {
            Product product = ProductRepository.searchProduct(productName);
            if (product instanceof PhysicalProduct) {
                weight += ((PhysicalProduct) product).getWeight();
            }
        }
        return weight;
    }

    @Override
    public int compareTo(ShoppingCart cart2) {
        int compareInt = 0;
        double compareWeight = cart2.getTotalWeight();
        if ((this.getTotalWeight() - compareWeight) > 0) {
            compareInt = 1;
        } else if ((this.getTotalWeight() - compareWeight) < 0) {
            compareInt = -1;
        } else {
            compareInt = 0;
        }
        return compareInt;
    }

    public static void main(String[] args) {
        PhysicalProduct p1 = new PhysicalProduct();
        p1.setName("iphone");
        ProductRepository.addProduct(p1);
        PhysicalProduct p2 = new PhysicalProduct();
        p2.setName("xiami");
        ProductRepository.addProduct(p2);
        for (String string : ProductRepository.products.keySet()) {
            System.out.println(string);
        }
    }

}
