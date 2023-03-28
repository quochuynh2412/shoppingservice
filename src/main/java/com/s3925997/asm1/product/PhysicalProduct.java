package com.s3925997.asm1.product;

/**
 * @author <Le Trinh Quoc Huynh - s3925997>
 */
public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String name, String description, int quantityAvailable, double price,
            double weight) {
        super(name, description, quantityAvailable, price);
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PHYSICAL - " + this.getName();
    }

}
