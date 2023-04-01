package com.s3925997.asm1.product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PhysicalProductTest {

    @Test
    public void testToString() {
        PhysicalProduct p1 = new PhysicalProduct("iPhone", "new", 23, 1599.9, 0.9);
        assertEquals("PHYSICAL - iPhone", p1.toString());
    }
}
