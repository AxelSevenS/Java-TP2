package TP2;

import java.util.Scanner;

public class TP24 {

    /**
     *  @author     Axel Sevenet
     *  @summary    Calcule le factoriel de n
     *  @param   n  Le nombre des termes de la suite à additionner
     *  @return     La somme des n premiers termes
     */
    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    /**
     *  @author     Axel Sevenet
     *  @summary    Calcule le factoriel de n
     *  @param   n  Le nombre des termes de la suite à additionner
     *  @return     La somme des n premiers termes
     */
    public static double factorial(double n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    /**
     *  @author     Axel Sevenet
     *  @param   n  Le nombre des termes de la suite à additionner
     *  @return     La somme des n premiers termes
     */
    public static double Cnp(double n, double p) {
        if ( p > n || n < 0 || p < 0 ) {
            throw new IllegalArgumentException("n et p doivent être positifs, p doit être inférieur à n.");
        }

        return factorial(n) / ( factorial(n-p) * factorial(p) );
    }

    /**
     *  @author             Axel Sevenet
     *  @param  scanner     Le scanner pour lire les entrées de l'utilisateur.
     *  @return             Un booléen indicant si la fonction a réussi ou non.
     */
    public static boolean run(Scanner scanner) {

        int input = Utility.readInt(scanner, "Entrez le nombre de terme de la suite à calculer : \n    0- Sortir\n", (x) -> x > 0);

        System.out.printf("Le factoriel de %d est %d\n", input, factorial(input));

        System.out.println( Cnp(50, 5) * Cnp(11, 2) );

        return true;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while ( run(scanner) );
    }
}
