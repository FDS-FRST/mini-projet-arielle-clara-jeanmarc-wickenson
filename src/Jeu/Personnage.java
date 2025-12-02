package Jeu;

public class Personnage {

        private String nom;
        private int vie;
        private int attaque;

        public Personnage(String nom, int vie, int attaque) {
            this.nom = nom;
            this.vie = vie;
            this.attaque = attaque;
        }

        public void attaquer(Personnage cible) {
            if (!this.estVivant()) {
                System.out.println(this.nom + " est mort et ne peut pas attaquer !");
                return;
            }
            if (!cible.estVivant()) {
                System.out.println(cible.nom + " est déjà mort !");
                return;
            }

            System.out.println(this.nom + " attaque " + cible.nom + " !");
            cible.vie -= this.attaque;
            if (cible.vie < 0) {
                cible.vie = 0;
            }
            System.out.println(cible.nom + " perd " + this.attaque + " points de vie.");
        }

        public boolean estVivant() {
            return this.vie > 0;
        }

        public void afficherEtat() {
            System.out.println(this.nom + " - " + this.vie + " HP");
        }

        public String getNom() {
            return nom;
        }

        public int getVie() {
            return vie;
        }

}
