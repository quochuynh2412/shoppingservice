package com.s3925997.asm1.product;

/**
 * @author <Le Trinh Quoc Huynh - s3925997>
 */
public class DigitalProduct extends Product {
    public DigitalProduct(String name, String description, int quantityAvailable, double price) {
        super(name, description, quantityAvailable, price);
    }

    public String getAllDetails() {
        String productDetail = "Name: " + this.getName() +
                "\n\tType: Digital\n\tDescription: " + this.getDescription() +
                "\n\tAvailable quantity: " + this.getQuantityAvailable() +
                "\n\tPrice: " + this.getPrice();
        return productDetail;
    }

    @Override
    public String toString() {
        return "PHYSICAL - " + this.getName();
    }
}
