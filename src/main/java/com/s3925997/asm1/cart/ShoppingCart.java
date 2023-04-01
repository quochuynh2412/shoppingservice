package com.s3925997.asm1.cart;

import java.util.HashSet;
import java.util.Set;
import com.s3925997.asm1.product.*;
import com.s3925997.asm1.repo.*;

/**
 * @author <Le Trinh Quoc Huynh - s3925997>
 */
public class ShoppingCart implements Comparable<ShoppingCart> {
    private String cartId;
    private Set<String> products;
    private static final double shippingBaseFee = 0.1;

    public ShoppingCart() {
        this.products = new HashSet<String>();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Set<String> getProducts() {
        return products;
    }

    public boolean addItem(String productName) {
        Product product = ProductRepository.searchProduct(productName);
        if (product.getQuantityAvailable() == 0) {
            return false;
        } else {
            if (products.contains(productName.trim())) {
                return false;
            } else {
                products.add(productName);
                ProductRepository.decreaseQuantity(productName);
                return true;
            }
        }
    }

    public boolean removeItem(String productName) {
        if (!products.contains(productName.trim())) {
            return false;
        } else {
            products.remove(productName);
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
                amount += ((DigitalProduct) product).getPrice();
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

}
