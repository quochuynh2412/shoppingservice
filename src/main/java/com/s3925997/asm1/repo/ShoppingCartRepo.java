package com.s3925997.asm1.repo;

import java.util.*;
import com.s3925997.asm1.cart.ShoppingCart;

/**
 * @author <Le Trinh Quoc Huynh - s3925997>
 */
public final class ShoppingCartRepo {
    private static ArrayList<ShoppingCart> repo = new ArrayList<ShoppingCart>();

    public static ShoppingCart getCart(int index) {
        return repo.get(index);
    }

    public static ArrayList<ShoppingCart> getRepo() {
        return repo;
    }

    public static boolean createNewCart() {
        String cartId = String.valueOf(repo.size() - 1);
        ShoppingCart shoppingCart = new ShoppingCart();
        repo.add(shoppingCart);
        return true;
    }

    public static boolean addProductToCart(int i, String productName) {
        ShoppingCart shoppingCart = repo.get(i);
        boolean added = shoppingCart.addItem(productName);
        repo.set(i, shoppingCart);
        return added;
    }

    public static void displayAllCart() {
    }

    public static void sortCarts() {
        Collections.sort(repo);
    }
}
