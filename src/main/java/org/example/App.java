package org.example;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("2 + 3 = " + calc.add(2, 3));
        System.out.println("6 - 4 = " + calc.subtract(6, 4));
        System.out.println("5 * 3 = " + calc.multiply(5, 3));
        System.out.println("8 / 2 = " + calc.divide(8, 2));
    }
}
