package com.s3925997.asm1.product;

public class PhysicalProduct extends Product {
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PHYSICAL - " + this.getName();
    }

}
