package TP2;

import java.util.Scanner;

public class ArrayUtil {

    /**
     * Demande à l'utilisateur de Rentrer le contenu d'un tableau de strings
     *  @author            Axel Sevenet
     *  @param  scanner    Le scanner où doit être entré le Tableau
     *  @return            Le tableau composé des nombres donnés par l'Utilisateur
     */
    public static String[] stringArrayFromInput(Scanner scanner) {
        int size = -1;

        while (size < 1) {
            System.out.println("Entrez la taille du tableau : ");
            System.out.println("  (0 pour sortir) ");
            size = scanner.nextInt();
            if (size == 0)
                return new String[]{};
        }

        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.printf( "Entrez la valeur de l'élément %d : ", i );
            array[i] = scanner.next();
        }
        return array;
    }

    /**
     * Demande à l'utilisateur de Rentrer le contenu d'un tableau de doubles
     *  @author            Axel Sevenet
     *  @param  scanner    Le scanner où doit être entré le Tableau
     *  @return            Le tableau composé des nombres donnés par l'Utilisateur
     */
    public static double[] numberArrayFromInput(Scanner scanner) {
        int size = -1;

        while (size < 1) {
            System.out.println("Entrez la taille du tableau : ");
            System.out.println("  (0 pour sortir) ");
            size = scanner.nextInt();
            if (size == 0)
                return new double[]{};
        }

        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            System.out.printf( "Entrez la valeur de l'élément %d : ", i );
            array[i] = scanner.nextDouble();
        }
        return array;
    }

    /**
     * Demande à l'utilisateur de Rentrer le contenu d'un tableau deux-dimensionnel de strings
     *  @author            Axel Sevenet
     *  @param  scanner    Le scanner où doit être entré le Tableau
     *  @return            Le tableau 2D composé des nombres donnés par l'Utilisateur
     */
    public static String[][] string2DArrayFromInput(Scanner scanner) {
        int size = -1;

        while (size < 0) {
            System.out.println("Entrez la taille du tableau : ");
            System.out.println("    0- Sortir");
            size = scanner.nextInt();
        }

        if (size == 0) return null;

        String[][] array = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("Entrez la valeur de l'élément [%d,%d] : ", i, j);
                array[i][j] = scanner.next();
            }
        }
        return array;
    }

    /**
     * Demande à l'utilisateur de Rentrer le contenu d'un tableau deux-dimensionnel de doubles
     *  @author            Axel Sevenet
     *  @param  scanner    Le scanner où doit être entré le Tableau
     *  @return            Le tableau 2D composé des nombres donnés par l'Utilisateur
     */
    public static double[][] number2DArrayFromInput(Scanner scanner) {
        int size = -1;

        while (size < 0) {
            System.out.println("Entrez la taille du tableau : ");
            System.out.println("    0- Sortir");
            size = scanner.nextInt();
        }

        if (size == 0) return null;

        double[][] array = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("Entrez la valeur de l'élément [%d,%d] : ", i, j);
                array[i][j] = scanner.nextFloat();
            }
        }
        return array;
    }

    /**
     *  @author         Axel Sevenet
     *  @param  array   Le tableau de doubles
     *  @param  row     Le numéro de la ligne
     *  @return         La somme des nombres dans la ligne row du tableau array
     */
    public static double rowSum(double[][] array, int row) {
        double sum = 0;
        for (double number : array[row]) {
            sum += number;
        }
        return sum;
    }

    /**
     *  @author         Axel Sevenet
     *  @param  array   Le tableau de doubles
     *  @param  column  Le numéro de la colonne
     *  @return         La somme des nombres dans la colonne column du tableau array
     */
    public static double columnSum(double[][] array, int column) {
        double sum = 0d;
        for (double[] row : array) {
            sum += row[column];
        }
        return sum;
    }

    /**
     *  @author         Axel Sevenet
     *  @param  array   Le tableau de doubles
     *  @return         La somme de tous les nombres d'un tableau 2D de doubles
     */
    public static double sum(double[] array) {
        double sum = 0;
        for (double number : array) {
            sum += number;
        }
        return sum;
    }

    /**
     *  @author         Axel Sevenet
     *  @param  array   Le tableau de doubles
     *  @return         La somme de tous les nombres d'un tableau 2D de doubles
     */
    public static double sum(double[][] array) {
        double sum = 0;
        for (double[] row : array) {
            for (double number : row) {
                sum += number;
            }
        }
        return sum;
    }

    /**
     * Affiche dans le terminal les entrées d'un tableau, ainsi que les sommes des lignes, colonnes et de toutes les entrées
     *  @author         Axel Sevenet
     *  @param  array   Le tableau de doubles
     */
    public static void display(double[][] array) {
        String[][] displayArray = new String[array.length + 1][array.length + 1];

        for (int i = 0; i < displayArray.length; i++) {
            for (int j = 0; j < displayArray.length; j++) {
                if (i < array.length && j < array.length) {
                    displayArray[i][j] = String.format("%s", array[i][j]);
                } else if (i == array.length && j == array.length) {
                    displayArray[i][j] = String.format("(%s)", sum(array)/(array.length) );
                } else if (i == array.length) {
                    displayArray[i][j] = String.format("(%s)", columnSum(array, j)/array.length );
                } else if (j == array.length) {
                    displayArray[i][j] = String.format("(%s)", rowSum(array, i)/array.length );
                }
            }
        }
        
        display(displayArray);
    }

    /**
     * Affiche dans le terminal les entrées d'un tableau
     *  @author         Axel Sevenet
     *  @param  array   Le tableau de strings
     */
    public static void display(String[][] array) {

        for (String[] strings : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("%s\t", strings[j]);
            }
            System.out.println();
        }
    }
}
