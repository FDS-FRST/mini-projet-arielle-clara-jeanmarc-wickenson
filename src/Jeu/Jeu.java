package Jeu;

import java.util.Scanner;

public class Jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le Jeu de Combat !");
        System.out.print("Joueur 1, entre ton nom : ");
        String nomJ1 = scanner.nextLine();
        Joueur joueur1 = new Joueur(nomJ1, scanner);

        System.out.print("Joueur 2, entre ton nom : ");
        String nomJ2 = scanner.nextLine();
        Joueur joueur2 = new Joueur(nomJ2, scanner);

        int tour = 1;
        while (joueur1.aEncoreDesPersonnagesVivants() && joueur2.aEncoreDesPersonnagesVivants()) {
            System.out.println("\n--- TOUR " + tour + " ---");

            // Tour du joueur 1
            joueur1.afficherEquipe();
            Personnage attaquant = joueur1.choisirPersonnageVivant(scanner);
            joueur2.afficherEquipe();
            Personnage cible = joueur2.choisirPersonnageVivant(scanner);
            attaquant.attaquer(cible);

            // Vérifier si joueur 2 est encore en vie
            if (!joueur2.aEncoreDesPersonnagesVivants()) break;

            // Tour du joueur 2
            joueur2.afficherEquipe();
            Personnage attaquant2 = joueur2.choisirPersonnageVivant(scanner);
            joueur1.afficherEquipe();
            Personnage cible2 = joueur1.choisirPersonnageVivant(scanner);
            attaquant2.attaquer(cible2);

            tour++;
        }

        // Fin du jeu
        if (joueur1.aEncoreDesPersonnagesVivants()) {
            System.out.println("Victoire de " + joueur1.getNom() + " ! Tous les personnages de " + joueur2.getNom() + " sont éliminés.");
        } else {
            System.out.println("Victoire de " + joueur2.getNom() + " ! Tous les personnages de " + joueur1.getNom() + " sont éliminés.");
        }

        scanner.close();
    }
}
