package TP2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choisissez un TP :");
            System.out.println("    0- Sortir");
            System.out.println("    1- TP2.1 - TP2.2");
            System.out.println("    2- TP2.3");
            System.out.println("    3- TP2.4");
            System.out.println("    4- TP2.5");
            int input = scanner.nextInt();
    
            switch (input) {
                case 1:
                    TP21.run(scanner);
                    break;
                case 2:
                    TP23.run(scanner);
                    break;
                case 3:
                    TP24.run(scanner);
                    break;
                case 4:
                    TP25.run(scanner);
                    break;
                default:
                    return;
            }
        }
        
    }
}
