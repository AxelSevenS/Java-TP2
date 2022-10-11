package TP2;

import java.util.Scanner;

import java.util.function.Predicate;

public class Utility {


    public static int readInt(Scanner scanner, String message, Predicate<Integer> predicate) {
        int value;
        do {
            System.out.print(message);
            value = scanner.nextInt();
        } while (!predicate.test(value));
        return value;
    }

    public static double readDouble(Scanner scanner, String message, Predicate<Double> predicate) {
        double value;
        do {
            System.out.print(message);
            value = scanner.nextDouble();
        } while (!predicate.test(value));
        return value;
    }
    
}
