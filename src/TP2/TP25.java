package TP2;

import java.util.Scanner;

public class TP25 {

    /**
     *  @author             Axel Sevenet
     *  @param  scanner     Le scanner pour lire les entrées de l'utilisateur.
     *  @param  matchAmount Le nombre d'allumettes à retirer pour gagner.
     *  @summary            Joue au jeu des allumettes. Celui qui retire la dernière allumette a gagné.
     */
    private static void gameOfNim(Scanner scanner, int matchAmount) {

        int matchesLeft = matchAmount;

        // On choisit le joueur aléatoirement
        boolean playerTurn = Math.random() <= 0.5;

        if (playerTurn) {
            System.out.println("Vous commencez.");
        } else {
            System.out.println("L'ordinateur commence.");
        }

        while ( matchesLeft > 0 ) {
                
            int matchesTaken;
            if (playerTurn) {
                matchesTaken = Utility.readInt(scanner, "Choisir le nombre d'allumette à prendre (1, 2 ou 3) : ", (x) -> x > 0 && x < 4);
            } else {
                // L'ordinateur prend un nombre toujours trop petit pour que le joueur puisse gagner
                matchesTaken = 3 - (matchesLeft % 3);
                System.out.printf("L'ordinateur a pris %d allumette(s)\n", matchesTaken);
            }

            // On retire les allumettes en empêchant le nombre d'allumettes restantes d'être négatif
            matchesLeft = Math.max(matchesLeft - matchesTaken, 0);
            System.out.printf("Il reste %d allumettes.\n", matchesLeft);


            if (matchesLeft <= 0) {
                if (playerTurn) {
                    System.out.println("Vous avez gagné !");
                } else {
                    System.out.println("Vous avez perdu !");
                }
            }

            playerTurn = !playerTurn;

        }
    }


    /**
     *  @author             Axel Sevenet
     *  @param  scanner     Le scanner pour lire les entrées de l'utilisateur.
     *  @return             Un booléen indicant si la fonction a réussi ou non.
     */
    public static boolean run(Scanner scanner) {

        int matchAmount = Utility.readInt(scanner, "Choisir le nombre d'allumette de départ ( > 15) : \n    0- sortir", (x) -> x > 15 || x == 0);

        if (matchAmount == 0) return false;

        gameOfNim(scanner, matchAmount);

        return true;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while ( run(scanner) );
    }
}
