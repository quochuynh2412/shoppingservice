package com.s3925997.asm1.product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DigitalProductTest {

    @Test
    public void testToString() {
        DigitalProduct product = new DigitalProduct("Harry Potter 2", "HP and the ...", 150, 25.4);
        assertEquals("DIGITAL - Harry Potter 2", product.toString());
    }
}
