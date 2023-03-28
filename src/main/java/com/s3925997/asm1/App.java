package com.s3925997.asm1;

import java.util.*;

import com.s3925997.asm1.product.*;
import com.s3925997.asm1.repo.*;
import com.s3925997.asm1.util.*;

/**
 * @author <Le Trinh Quoc Huynh - s3925997>
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppUtility util = new AppUtility();
        String inputString = "";
        boolean exit = false;
        while (!exit) {
            System.out.println("-------------------------------------");
            System.out.println("\tOnline Shopping Application");
            System.out.println("-------------------------------------");
            System.out.println("Please choose a service:");
            System.out.println("1/ View all products");
            System.out.println("2/ Create a product");
            System.out.println("3/ Edit product");
            System.out.println("4/ Create new shopping cart");
            System.out.println("5/ Add product to current shopping cart");
            System.out.println("6/ Display cart amount");
            System.out.println("7/ Display all shopping carts");
            System.out.println("8/ Exit");
            switch (util.getIntInput()) {
                case 1: {
                    for (Product product : ProductRepository.getProductsMap().values()) {
                        System.out.println(product.getAllDetails());
                    }
                }
                case 2: {
                    System.out.print("-------------------------------------");
                    String name;
                    String description;
                    int quantityAvailable;
                    double price;
                    double weight;
                    System.out.println(
                            "\n\n\n\n\n-------------------------------------\n\tCreate new product\n");
                    System.out.println("Select a product type: \n\t1/Physical Product\n\t2/Digital Product");
                    switch (util.getIntInput()) {
                        case 1: {
                            System.out.println("fhsajk");
                            System.out.println("Enter product name: ");
                            name = util.getStringInput();
                            System.out.println("Enter product description: ");
                            description = util.getStringInput();
                            System.out.println("Enter product price: ");
                            price = util.getDoubleInput();
                            System.out.println("Enter product available quantity: ");
                            quantityAvailable = util.getIntInput();
                            System.out.println("Enter product weight: ");
                            weight = util.getDoubleInput();
                            PhysicalProduct product = new PhysicalProduct(name, description, quantityAvailable, price,
                                    weight);
                            ProductRepository.addProduct(product);
                            break;
                        }
                        case 2: {
                            System.out.println("Enter product name: ");
                            name = util.getStringInput();
                            System.out.println("Enter product description: ");
                            description = util.getStringInput();
                            System.out.println("Enter product price ");
                            price = util.getDoubleInput();
                            System.out.println("Enter product available quantity: ");
                            quantityAvailable = Integer.parseInt(util.getStringInput());
                            System.out.println("Enter product weight: ");
                            weight = util.getDoubleInput();
                            DigitalProduct product = new DigitalProduct(name, description, quantityAvailable, price);
                            ProductRepository.addProduct(product);
                            break;
                        }
                    }
                    System.out.println("Successfully created a new product:");
                    break;
                }
                case 8: {
                    exit = true;
                    break;
                }
            }
        }
    }
}
