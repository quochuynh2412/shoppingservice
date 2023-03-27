package com.s3925997.asm1.repo;

import java.util.*;

import com.s3925997.asm1.cart.ShoppingCart;

public class ShoppingCartRepo {
    private ArrayList<ShoppingCart> repo;

    public ShoppingCartRepo() {
    }

    public boolean createNewCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        repo.add(shoppingCart);
        return true;
    }

    public void displayAllCart() {

    }
}
