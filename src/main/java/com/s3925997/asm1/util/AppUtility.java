// package com.s3925997.asm1.util;

// import java.util.Scanner;

// public class AppUtility {
// public AppUtility() {
// }

// public String getStringInput() {
// Scanner scanner = new Scanner(System.in);
// System.out.print(">>> ");
// String inputString = scanner.nextLine();
// return inputString;
// }

// public int getIntInput() {
// boolean done = false;
// int inputInt = 0;
// while (!done) {
// try {
// Scanner scanner = new Scanner(System.in);
// System.out.print(">>> ");
// inputInt = scanner.nextInt();
// if (inputInt < 0) {
// System.out.println("Invalid value entered. Must be a non-negative integer.
// Please try again.");
// } else {
// done = true;
// }
// } catch (Exception e) {
// System.out.println("Invalid value entered. Must be a non-negative integer.
// Please try again.");
// }
// }
// return inputInt;
// }

// public int getIntInput(int i1, int i2) {
// boolean done = false;
// int inputInt = 0;
// while (!done) {
// try {
// Scanner scanner = new Scanner(System.in);
// System.out.print(">>> ");
// inputInt = scanner.nextInt();
// if ((inputInt < 0) || !(i1 <= inputInt && inputInt < i2)) {
// System.out.println("Invalid value entered. Must be a non-negative integer in
// range ("
// + String.valueOf(i1) + "," + String.valueOf(i2) + "). Please try again.");
// } else {
// done = true;
// }
// } catch (Exception e) {
// System.out.println("Invalid value entered. Must be a non-negative integer.
// Please try again.");
// }
// }
// return inputInt;
// }

// public double getDoubleInput() {
// boolean done = false;
// double inputDouble = 0;
// while (!done) {
// try {
// Scanner scanner = new Scanner(System.in);
// System.out.print(">>> ");
// inputDouble = scanner.nextDouble();
// if (inputDouble < 0) {
// System.out.println("Invalid value entered. Must be non-negative. Please try
// again.");
// } else {
// done = true;
// }
// } catch (Exception e) {
// System.out.println("Invalid value entered. Must be non-negative. Please try
// again.");
// }
// }
// return inputDouble;
// }
// }
