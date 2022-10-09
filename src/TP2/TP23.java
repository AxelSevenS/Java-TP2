package TP2;

import java.util.Scanner;

public class TP23 {

    /**
    *  @author                      Axel Sevenet
    *  @param   isCouple            Si l'utilisateur est en couple.
    *  @param   numberOfChildren    Le nombre d'enfants dans le foyer de l'utilisateur.
    *  @return                      Le quotient familial du foyer.
    */
    public static double computeFamilyQuotient(boolean isCouple, int numberOfChildren) {
        return (isCouple ? 2 : (numberOfChildren > 0 ? 1.5 : 1)) + numberOfChildren * 0.5;
    }

    /**
    *  @author          Axel Sevenet
    *  @param   salary  Le salaire de l'utilisateur.
    *  @return          L'impôt redevable de l'Utilisateur, avec un quotient familial de 1.
    */
    public static double computeTaxAmount(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Le salaire doit être positif");
        }
        
        double tax = 0;
        
        if (salary > 10225) {
            double boundSalary = Math.min(salary, 26070);
            tax += 0.11 * (boundSalary - 10225);
        }
        
        if (salary > 26070) {
            double boundSalary = Math.min(salary, 74545);
            tax += 0.3 * (boundSalary - 26070);
        }
        
        if (salary > 74545) {
            double boundSalary = Math.min(salary, 160336);
            tax += 0.41 * (boundSalary - 74545);
        }
        
        if (salary > 160336) {
            tax += 0.45 * (salary - 160336);
        }

        return tax;
    }


    /**
     *  @author             Axel Sevenet
     *  @param  scanner     Le scanner pour lire les entrées de l'utilisateur.
     *  @return             Un booléen indicant si la fonction a réussi ou non.
     */
    public static boolean run(Scanner scanner) {

        System.out.print("Êtes-vous marié ou pacsé? (y/n)");
        String mariedInput = scanner.next();
        boolean isMaried = mariedInput.equals("y") || mariedInput.equals("Y") || mariedInput.equals("yes") || mariedInput.equals("Yes");


        int childrenAmount;
        do {
            System.out.print("Combien avez-vous d'enfants?");
            childrenAmount = scanner.nextInt();
        } 
        while (childrenAmount < 0);


        double salary;
        do {
            System.out.print("Quel est le salaire total de votre foyer?");
            salary = scanner.nextDouble();
        } 
        while (salary < 0);


        double familyQuotient = computeFamilyQuotient(isMaried, childrenAmount);

        double result = computeTaxAmount(salary / familyQuotient) * familyQuotient;


        System.out.printf("Le montant de vos impôts est de %.2f€.", result);
        

        return true;

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
