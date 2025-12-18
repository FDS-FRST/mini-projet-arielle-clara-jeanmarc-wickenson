import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue dans le Jeu de Combat !");

        // Création des joueurs
        System.out.print("Joueur 1, entre ton nom : ");
        Joueur j1 = new Joueur(sc.nextLine());

        System.out.print("Joueur 2, entre ton nom : ");
        Joueur j2 = new Joueur(sc.nextLine());

        // Création des équipes
        creerEquipe(sc, j1);
        creerEquipe(sc, j2);

        int tour = 1;

        // Boucle principale du jeu
        while (j1.aEncoreDesPersonnagesVivants() && j2.aEncoreDesPersonnagesVivants()) {

            System.out.println("\n--- TOUR " + tour + " ---");

            tourJoueur(sc, j1, j2);
            if (!j2.aEncoreDesPersonnagesVivants()) break;

            tourJoueur(sc, j2, j1);

            tour++;
        }

        // Fin du jeu
        if (j1.aEncoreDesPersonnagesVivants()) {
            System.out.println("Victoire de " + j1.nom + " !");
        } else {
            System.out.println("Victoire de " + j2.nom + " !");
        }

        sc.close();
    }

    // Méthode pour créer une équipe
    static void creerEquipe(Scanner sc, Joueur joueur) {
        System.out.println("\n" + joueur.nom + ", crée ton équipe :");

        for (int i = 0; i < 3; i++) {
            System.out.print("Nom du personnage " + (i + 1) + " : ");
            String nomPerso = sc.nextLine();
            joueur.equipe[i] = new Personnage(nomPerso);
        }
    }

    // Tour d'un joueur
    static void tourJoueur(Scanner sc, Joueur attaquant, Joueur defenseur) {

        System.out.println("\n" + attaquant.nom + ", choisis ton attaquant :");
        attaquant.afficherEquipe();
        int choixAttaquant = sc.nextInt();

        Personnage pAttaquant = attaquant.choisirPersonnageVivant(choixAttaquant);
        if (pAttaquant == null) return;

        System.out.println("Choisis la cible chez " + defenseur.nom + " :");
        defenseur.afficherEquipe();
        int choixCible = sc.nextInt();
        sc.nextLine(); // vide le buffer

        Personnage pCible = defenseur.choisirPersonnageVivant(choixCible);
        if (pCible == null) return;

        pAttaquant.attaquer(pCible);

        System.out.println("\nEtat de l'équipe de " + defenseur.nom + " :");
        defenseur.afficherEquipe();
    }
}