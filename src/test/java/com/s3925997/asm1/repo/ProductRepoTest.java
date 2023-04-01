package com.s3925997.asm1.repo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import com.s3925997.asm1.product.*;

public class ProductRepoTest {
    @BeforeEach
    void setUp() {
        PhysicalProduct p1 = new PhysicalProduct("Samsung", "new", 23, 1599.9, 0.9);
        PhysicalProduct p2 = new PhysicalProduct("Huawei", "new", 24, 599.9, 1.2);
        DigitalProduct p3 = new DigitalProduct("Rich dad, poor dad", "Book", 150, 25.4);
        DigitalProduct p4 = new DigitalProduct("Coursera AI course", "Book", 123, 32.5);
        ProductRepository.addProduct(p4);
        ProductRepository.addProduct(p3);
        ProductRepository.addProduct(p2);
        ProductRepository.addProduct(p1);
    }

    @Test
    public void testSearchPhysicalProduct() {
        Product product = ProductRepository.searchProduct("Samsung");
        assertNotNull(product);
        assertEquals("Samsung", product.getName());
        assertEquals("new", product.getDescription());
        assertEquals(23, product.getQuantityAvailable());
        assertEquals(1599.9, product.getPrice());
        assertEquals(0.9, ((PhysicalProduct) product).getWeight());
    }

    @Test
    public void testSearchDigitalProduct() {
        Product product = ProductRepository.searchProduct("Rich dad, poor dad");
        assertNotNull(product);
        assertEquals("Rich dad, poor dad", product.getName());
        assertEquals("Book", product.getDescription());
        assertEquals(150, product.getQuantityAvailable());
        assertEquals(25.4, product.getPrice());
    }

    @Test
    public void testSearchByIndexPhysicalProduct() {
        Product product = ProductRepository.searchByIndex(3);
        assertNotNull(product);
        assertEquals("Samsung", product.getName());
        assertEquals("new", product.getDescription());
        assertEquals(23, product.getQuantityAvailable());
        assertEquals(1599.9, product.getPrice());
        assertEquals(0.9, ((PhysicalProduct) product).getWeight());
    }

    @Test
    public void testSearchByIndexDigitalProduct() {
        Product product = ProductRepository.searchByIndex(1);
        assertNotNull(product);
        assertEquals("Rich dad, poor dad", product.getName());
        assertEquals("Book", product.getDescription());
        assertEquals(150, product.getQuantityAvailable());
        assertEquals(25.4, product.getPrice());
    }

    @Test
    public void testAddNonExistedPhysicalProduct() {
        PhysicalProduct pp1 = new PhysicalProduct("Macbook", "good condition", 33, 1999.9, 1.3);
        boolean isAdded1 = ProductRepository.addProduct(pp1);
        Product pp2 = ProductRepository.searchProduct("Macbook");
        assertTrue(isAdded1);
        assertNotNull(pp2);
        assertEquals("Macbook", pp2.getName());
        assertEquals("good condition", pp2.getDescription());
        assertEquals(33, pp2.getQuantityAvailable());
        assertEquals(1999.9, pp2.getPrice());
        assertEquals(1.3, ((PhysicalProduct) pp2).getWeight());
    }

    @Test
    public void testAddNonExistedDigitalProduct() {
        DigitalProduct dp1 = new DigitalProduct("Mona Lisa", "Leonardo Da Vinci", 1, 400000);
        boolean isAdded2 = ProductRepository.addProduct(dp1);
        Product dp2 = ProductRepository.searchProduct("Mona Lisa");
        assertTrue(isAdded2);
        assertNotNull(dp2);
        assertEquals("Mona Lisa", dp2.getName());
        assertEquals("Leonardo Da Vinci", dp2.getDescription());
        assertEquals(1, dp2.getQuantityAvailable());
        assertEquals(400000, dp2.getPrice());
    }

    @Test
    public void testAddExistedPhysicalProduct() {
        PhysicalProduct pp1 = new PhysicalProduct("Samsung", "new", 23, 1599.9, 0.9);
        boolean isAdded = ProductRepository.addProduct(pp1);
        assertFalse(isAdded);
    }

    @Test
    public void testAddExistedDigitalProduct() {
        DigitalProduct product = new DigitalProduct("Rich dad, poor dad", "Book", 150, 25.4);
        boolean isAdded = ProductRepository.addProduct(product);
        assertFalse(isAdded);
    }

    @Test
    public void decreaseQuantityPhysicalProduct() {
        ProductRepository.decreaseQuantity("Huawei");
        assertEquals(23, ProductRepository.searchProduct("Huawei").getQuantityAvailable());
    }

    @Test
    public void decreaseQuantityDigitalProduct() {
        ProductRepository.decreaseQuantity("Coursera AI course");
        assertEquals(122, ProductRepository.searchProduct("Coursera AI course").getQuantityAvailable());
    }

    @Test
    public void increaseQuantityPhysicalProduct() {
        ProductRepository.increaseQuantity("Samsung");
        assertEquals(24, ProductRepository.searchProduct("Samsung").getQuantityAvailable());
    }

    @Test
    public void increaseQuantityDigitalProduct() {
        ProductRepository.increaseQuantity("Rich dad, poor dad");
        assertEquals(151, ProductRepository.searchProduct("Rich dad, poor dad").getQuantityAvailable());
    }

    @Test
    public void testResetRepo() {
        ProductRepository.resetRepo();
        assertEquals(0, ProductRepository.getProductsMap().size());
    }

    @AfterEach
    public void cleanUp() {
        ProductRepository.resetRepo();
    }

}
