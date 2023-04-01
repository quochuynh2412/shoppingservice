package com.s3925997.asm1.cart;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import com.s3925997.asm1.product.*;
import com.s3925997.asm1.repo.*;

public class ShoppingCartTest {
    private ShoppingCart s1Cart;
    private ShoppingCart s2Cart;

    @BeforeEach
    void init() {
        s1Cart = new ShoppingCart();
        s2Cart = new ShoppingCart();
        PhysicalProduct p1 = new PhysicalProduct("iPhone", "new", 23, 1599.9, 0.9);
        PhysicalProduct p2 = new PhysicalProduct("Xiaomi", "new", 24, 599.9, 1.2);
        DigitalProduct p3 = new DigitalProduct("Harry Potter 2", "HP and the ...",
                150, 25.4);
        DigitalProduct p4 = new DigitalProduct("Harry Potter 7", "HP and the ...",
                123, 32.5);
        ProductRepository.addProduct(p4);
        ProductRepository.addProduct(p3);
        ProductRepository.addProduct(p2);
        ProductRepository.addProduct(p1);
        s1Cart.addItem("iPhone");
        s1Cart.addItem("Xiaomi");
        s1Cart.addItem("Harry Potter 2");
        s2Cart.addItem("Harry Potter 7");
        s2Cart.addItem("Harry Potter 2");
    }

    @Test
    public void testAddNonExistedItem() {
        assertTrue(s1Cart.addItem("Harry Potter 7"));
    }

    @Test
    public void testExistedAddItem() {
        assertFalse(s1Cart.addItem("iPhone"));
    }

    @Test
    public void testRemoveExistedItem() {
        assertTrue(s1Cart.removeItem("iPhone"));
    }

    @Test
    public void testRemoveNonExistedItem() {
        assertFalse(s1Cart.removeItem("Harry Potter 7"));
    }

    @Test
    public void testCartAmountWithPhysicalProduct() {
        assertEquals(2225.41, s1Cart.cartAmount());
    }

    @Test
    public void testCartAmountWithoutPhysicalProduct() {
        assertEquals(57.9, s2Cart.cartAmount());
    }

    @Test
    public void testTotalWeightWithPhysicalProduct() {
        assertEquals(2.1, s1Cart.getTotalWeight());
    }

    @Test
    public void testTotalWeightWithoutPhysicalProduct() {
        assertEquals(0, s2Cart.getTotalWeight());
    }

    @AfterEach
    public void cleanUp() {
        s1Cart = new ShoppingCart();
        s2Cart = new ShoppingCart();
        ProductRepository.resetRepo();
    }
}
