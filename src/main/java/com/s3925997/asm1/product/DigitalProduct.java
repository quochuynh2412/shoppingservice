package com.s3925997.asm1.product;

/**
 * @author <Le Trinh Quoc Huynh - s3925997>
 */
public class DigitalProduct extends Product {
    public DigitalProduct(String name, String description, int quantityAvailable, double price) {
        super(name, description, quantityAvailable, price);
    }

    @Override
    public String toString() {
        return "DIGITAL - " + this.getName();
    }
}
