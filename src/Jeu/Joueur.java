package Jeu;

import java.util.Scanner;

    public class Joueur {
        private String nom;
        private Personnage[] equipe;

        // Constructeur
        public Joueur(String nom, Scanner scanner) {
            this.nom = nom;
            this.equipe = new Personnage[3];

            System.out.println(nom + ", crée ton équipe :");
            for (int i = 0; i < 3; i++) {
                System.out.print("Nom du personnage " + (i + 1) + " : ");
                String nomPerso = scanner.nextLine();
                equipe[i] = new Personnage(nomPerso, 100, 20);
            }
        }

        // Vérifie si joueur a encore des personnages vivants
        public boolean aEncoreDesPersonnagesVivants() {
            for (Personnage p : equipe) {
                if (p.estVivant()) return true;
            }
            return false;
        }

        // Affiche l'équipe
        public void afficherEquipe() {
            System.out.println("État de l'équipe de " + nom + " :");
            for (int i = 0; i < equipe.length; i++) {
                System.out.print((i + 1) + ". ");
                equipe[i].afficherEtat();
            }
        }

        // Choisir un personnage vivant
        public Personnage choisirPersonnageVivant(Scanner scanner) {
            while (true) {
                System.out.print(nom + ", choisis ton personnage (1-3) : ");
                int choix = scanner.nextInt();
                scanner.nextLine(); // consommer retour ligne

                if (choix >= 1 && choix <= 3) {
                    Personnage p = equipe[choix - 1];
                    if (p.estVivant()) {
                        return p;
                    } else {
                        System.out.println("Ce personnage est mort, choisis-en un autre.");
                    }
                } else {
                    System.out.println("Choix invalide, recommence.");
                }
            }
        }

        // Getter
        public String getNom() {
            return nom;
        }

        public Personnage[] getEquipe() {
            return equipe;
        }

}

