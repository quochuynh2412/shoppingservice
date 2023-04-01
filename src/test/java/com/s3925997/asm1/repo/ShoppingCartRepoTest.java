package com.s3925997.asm1.repo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import com.s3925997.asm1.product.*;
import com.s3925997.asm1.cart.*;

public class ShoppingCartRepoTest {
    @BeforeEach
    public void setUp() {
        ShoppingCart s1Cart = new ShoppingCart();
        ShoppingCart s2Cart = new ShoppingCart();
        PhysicalProduct p1 = new PhysicalProduct("iPhone", "new", 23, 1599.9, 0.9);
        PhysicalProduct p2 = new PhysicalProduct("Xiaomi", "new", 24, 599.9, 1.2);
        DigitalProduct p3 = new DigitalProduct("Harry Potter 2", "HP and the ...", 150, 25.4);
        DigitalProduct p4 = new DigitalProduct("Harry Potter 7", "HP and the ...", 123, 32.5);
        ProductRepository.addProduct(p4);
        ProductRepository.addProduct(p3);
        ProductRepository.addProduct(p2);
        ProductRepository.addProduct(p1);
        s1Cart.addItem("iPhone");
        s1Cart.addItem("Xiaomi");
        s1Cart.addItem("Harry Potter 2");
        s2Cart.addItem("Harry Potter 7");
        s2Cart.addItem("Harry Potter 2");
        ShoppingCartRepo.addCart(s2Cart);
        ShoppingCartRepo.addCart(s1Cart);
    }

    @Test
    public void testAddProductToCart() {
        assertTrue(ShoppingCartRepo.addProductToCart(0, "iPhone"));
    }

    @Test
    public void testSortCarts() {
        ShoppingCartRepo.sortCarts();
        assertTrue(ShoppingCartRepo.getCart(0).getTotalWeight() < ShoppingCartRepo.getCart(1).getTotalWeight());
    }

    @Test
    public void testSortCartsReverse() {
        ShoppingCartRepo.resetRepo();
        ShoppingCart s1Cart = new ShoppingCart();
        ShoppingCart s2Cart = new ShoppingCart();
        s1Cart.addItem("iPhone");
        s1Cart.addItem("Xiaomi");
        s1Cart.addItem("Harry Potter 2");
        s2Cart.addItem("Harry Potter 7");
        s2Cart.addItem("Harry Potter 2");
        ShoppingCartRepo.addCart(s2Cart);
        ShoppingCartRepo.addCart(s1Cart);
        assertTrue(ShoppingCartRepo.getCart(0).getTotalWeight() < ShoppingCartRepo.getCart(1).getTotalWeight());
    }

    @AfterEach
    public void cleanUp() {
        ProductRepository.resetRepo();
        ShoppingCartRepo.resetRepo();
    }
}
