public class Joueur {

    String nom;
    Personnage[] equipe;

    // Constructeur
    public Joueur(String nom) {
        this.nom = nom;
        equipe = new Personnage[3];
    }

    // Vérifie s'il reste au moins un personnage vivant
    public boolean aEncoreDesPersonnagesVivants() {
        for (Personnage p : equipe) {
            if (p.estVivant()) {
                return true;
            }
        }
        return false;
    }

    // Affiche l'équipe
    public void afficherEquipe() {
        for (int i = 0; i < equipe.length; i++) {
            System.out.print((i + 1) + ". ");
            equipe[i].afficherEtat();
        }
    }

    // Choisir un personnage vivant
    public Personnage choisirPersonnageVivant(int choix) {
        Personnage p = equipe[choix - 1];

        if (p.estVivant()) {
            return p;
        } else {
            System.out.println("Ce personnage est mort !");
            return null;
        }
    }
}
