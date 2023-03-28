package com.s3925997.asm1.repo;

import java.util.*;
import com.s3925997.asm1.cart.ShoppingCart;

/**
 * @author <Le Trinh Quoc Huynh - s3925997>
 */
public final class ShoppingCartRepo {
    private static ArrayList<ShoppingCart> repo;

    public static boolean createNewCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        repo.add(shoppingCart);
        return true;
    }

    public static void displayAllCart() {

    }
}
