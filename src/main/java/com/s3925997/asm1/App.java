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
            System.out.println("5/ Display cart amount");
            System.out.println("6/ Display all shopping carts");
            System.out.println("7/ Exit");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    System.out.println(
                            "\n\n\n\n\n-------------------------------------");
                    for (Product product : ProductRepository.getProductsMap().values()) {
                        System.out.println("\t" + product.getName());
                        System.out.print("Type: ");
                        if (product instanceof PhysicalProduct) {
                            System.out.println("Physical");
                            System.out.println("Weight: " + ((PhysicalProduct) product).getWeight());
                        } else {
                            System.out.println("Digital");
                        }
                        System.out.println("Description: " + product.getDescription());
                        System.out.println("Price: " + product.getPrice());
                        System.out.println("Available quantity: " + product.getQuantityAvailable());
                        System.out.println(
                                "-------------------------------------\n");
                    }
                    break;
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
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1: {
                            System.out.println("Enter product name: ");
                            name = scanner.nextLine().trim();
                            System.out.println("Enter product description: ");
                            description = scanner.nextLine().trim();
                            System.out.println("Enter product price: ");
                            price = Double.parseDouble(scanner.nextLine());
                            System.out.println("Enter product available quantity: ");
                            quantityAvailable = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter product weight: ");
                            weight = Double.parseDouble(scanner.nextLine());
                            PhysicalProduct product = new PhysicalProduct(name, description, quantityAvailable, price,
                                    weight);
                            ProductRepository.addProduct(product);
                            break;
                        }
                        case 2: {
                            System.out.println("Enter product name: ");
                            name = scanner.nextLine().trim();
                            System.out.println("Enter product description: ");
                            description = scanner.nextLine().trim();
                            System.out.println("Enter product price: ");
                            price = Double.parseDouble(scanner.nextLine());
                            System.out.println("Enter product available quantity: ");
                            quantityAvailable = Integer.parseInt(scanner.nextLine());
                            DigitalProduct product = new DigitalProduct(name, description, quantityAvailable, price);
                            ProductRepository.addProduct(product);
                            break;
                        }
                    }
                    System.out.println("Successfully created a new product:");
                    break;
                }
                case 3: {
                    System.out.println("Product list: ");
                    int i = 1;
                    for (Product product : ProductRepository.getProductsMap().values()) {
                        System.out.println(String.valueOf(i) + "/ " + product.toString());
                        i++;
                    }
                    System.out.println("Please choose a product to edit");
                    int editProductInt = Integer.parseInt(scanner.nextLine());
                    Product product = ProductRepository.searchByIndex(editProductInt - 1);
                    System.out.println("\t" + product.getName());
                    System.out.print("Type: ");
                    if (product instanceof PhysicalProduct) {
                        System.out.println("Physical");
                        System.out.println("Weight: " + ((PhysicalProduct) product).getWeight());
                    } else {
                        System.out.println("Digital");
                    }
                    System.out.println("Description: " + product.getDescription());
                    System.out.println("Price: " + product.getPrice());
                    System.out.println("Available quantity: " + product.getQuantityAvailable());
                    System.out.println("What do you want to edit: \n1/Name\t2/");
                    break;
                }
                case 4: {
                    ShoppingCartRepo.createNewCart();
                    System.out.println("A new shopping cart has been created");
                    break;
                }
                case 5: {
                    PhysicalProduct p1 = new PhysicalProduct("iPhone", "new", 23, 1599.99, 0.9);
                    PhysicalProduct p2 = new PhysicalProduct("Xiaomi", "new", 24, 599.99, 1.2);
                    DigitalProduct p3 = new DigitalProduct("Harry Potter 2", "HP and the ...", 150, 25.4);
                    ProductRepository.addProduct(p3);
                    ProductRepository.addProduct(p2);
                    ProductRepository.addProduct(p1);
                    ShoppingCartRepo.createNewCart();
                    ShoppingCartRepo.addProductToCart(0, p1.getName());
                    ShoppingCartRepo.addProductToCart(0, p2.getName());
                    ShoppingCartRepo.addProductToCart(0, p3.getName());
                    ShoppingCartRepo.createNewCart();
                    ShoppingCartRepo.addProductToCart(1, p1.getName());
                    ShoppingCartRepo.addProductToCart(1, p3.getName());
                    ShoppingCartRepo.sortCarts();
                    for (int i = 0; i < ShoppingCartRepo.getRepo().size(); i++) {
                        System.out.printf("%d/ Cart %d:\n\tWeight: %6.2f\n\tTotal Amount: $%6.2f\n", i + 1, i + 1,
                                ShoppingCartRepo.getRepo().get(i).getTotalWeight(),
                                ShoppingCartRepo.getRepo().get(i).cartAmount());
                    }
                    break;
                }
                case 6: {

                }
                case 7: {
                    exit = true;
                    break;
                }
            }
        }
    }
}
