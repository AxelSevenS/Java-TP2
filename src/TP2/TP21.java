package TP2;

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

public class TP21 {



    public static class Archimède {

        /**
         *  @author     Axel Sevenet
         *  @param  X   Le Paramètre X de la fonction.
         *  @param  Y   Le Paramètre Y de la fonction.
         *  @return     La valeur de la fonction C(X,Y) = 2XY/(X+Y)
         */
        public static double Cn(double X, double Y) throws IllegalArgumentException {
            if (X < 0 || Y < 0) {
                throw new IllegalArgumentException("X et Y doivent être positifs");
            }

            return 2 * X * Y / (X + Y);
        }


        /**
         *  @author     Axel Sevenet
         *  @param  X   Le Paramètre X de la fonction.
         *  @param  Y   Le Paramètre Y de la fonction.
         *  @return     La valeur de la fonction I(X,Y) = √(V*Y)
         */
        public static double In(double X, double Y) throws IllegalArgumentException {
            if (X < 0 || Y < 0) {
                throw new IllegalArgumentException("X et Y doivent être positifs");
            }

            return Math.sqrt(X * Y);
        }
        

        /**
         *  @author     Axel Sevenet
         *  @param  N   Le nombre d'itérations de la fonction. Le résultat est plus précis avec un nombre élevé.
         *  @return     La valeur de la fonction I(X,Y) = √(V*Y)
         */
        public static double[] An(int N) throws IllegalArgumentException {
            if (N < 0) {
                throw new IllegalArgumentException("N doit être positif");
            }
            
            double X = 4;
            double Y = 2 * Math.sqrt(2);

            double[] results = new double[N*2];

            for (int i = 0; i < results.length; i += 2) {
                X = Cn(X, Y);
                Y = In(X, Y);
                results[i] = X;
                results[i+1] = Y;
            }

            return results;

        }

    }

    /**
     *  @author             Axel Sevenet
     *  @param  scanner     Le scanner pour lire les entrées de l'utilisateur.
     *  @return             Un booléen indicant si la fonction a réussi ou non.
     */
    public static boolean run(Scanner scanner) {

        int input = Utility.readInt(scanner, "Entrez une valeur positive (0 pour terminer) : ", (x) -> x >= 0);

        try {

            double[] results = Archimède.An(input);

            for (int i = 0; i < results.length; i += 2) {
                int trueI = i/2;
                System.out.printf( "X[%d] : %f ; Y[%d] : %f\n", trueI, results[i], trueI, results[i+1]);
            }

            return true;

        } catch (IllegalArgumentException e) {

            return false;
        }

    }

    
    /**
     *  @author         Axel Sevenet
     *  @summary        Fonction principale du programme. Éxécute le programme en boucle tant que l'Utilisateur donne une entrée valide.
     *  @param  args    Les arguments de la fonction main.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while ( run(scanner) );
    }
}
