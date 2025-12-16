[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/5Nw3YkbF)
# Mini-projet Java : Jeu de personnages (Console)

## 🎮 Objectif du mini-projet
Créer un jeu en **ligne de commande (console)** dans lequel :
- 2 joueurs s'affrontent
- Chaque joueur contrôle **3 personnages**
- Les personnages se battent tour par tour jusqu'à ce qu'un joueur n'ait plus de personnages en vie

Ce projet permet de pratiquer :
- La création de classes
- Les attributs et méthodes
- Les constructeurs
- Les interactions entre objets
- La manipulation de la console avec `Scanner`

---

## 🧱 Modélisation des classes

### 1. Classe Personnage
Chaque personnage possède :

**Attributs :**
- `String nom`
- `int vie` (ex: 100)
- `int attaque` (ex: 20)

**Constructeur :**
- Initialise le nom, la vie et la force d'attaque

**Méthodes :**
- `c` : diminue la vie de la cible
- `estVivant()` : retourne true si vie > 0
- `afficherEtat()` : affiche le nom et la vie restante

---

### 2. Classe Joueur

**Attributs :**
- `String nom`
- `Personnage[] equipe` (tableau de 3 personnages)

**Méthodes :**
- `choisirPersonnageVivant()` : retourne un personnage vivant
- `aEncoreDesPersonnagesVivants()` : vérifie si le joueur peut encore jouer
- `afficherEquipe()` : affiche les personnages et leur état

---

### 3. Classe Jeu (Main)
Contient la logique principale du jeu et la méthode `main()`.

---

## 🕹️ Déroulement du jeu

### Phase 1 : Création des joueurs
1. Demander le nom du joueur 1
2. Demander le nom du joueur 2

Pour chaque joueur :
- Créer 3 personnages avec :
  - un nom saisi par l'utilisateur
  - vie = 100
  - attaque = 20

---

### Phase 2 : Boucle de combat

Tant que les deux joueurs ont au moins un personnage vivant :

1. Le joueur 1 choisit :
   - Son personnage attaquant
   - Le personnage cible chez le joueur 2

2. Attaque exécutée
3. Affichage de l'état des personnages

4. Même chose pour le joueur 2

---

## ⚔️ Règles du combat

- Un personnage mort (vie <= 0) ne peut plus attaquer
- La vie ne peut pas être négative
- Chaque attaque enlève exactement 20 points

---

## 🖥️ Exemple d'interaction console

```
Bienvenue dans le Jeu de Combat !

Joueur 1, entre ton nom : Alice
Joueur 2, entre ton nom : Bob

Alice, crée ton équipe :
Nom du personnage 1 : Guerrier
Nom du personnage 2 : Mage
Nom du personnage 3 : Archer

Bob, crée ton équipe :
Nom du personnage 1 : Orc
Nom du personnage 2 : Troll
Nom du personnage 3 : Goblin

--- TOUR 1 ---
Alice choisit son attaquant : Guerrier
Alice attaque Orc
Orc perd 20 points de vie

Etat de l'équipe de Bob :
Orc - 80 HP
Troll - 100 HP
Goblin - 100 HP
```

---

## 🧭 Étapes guidées pour les étudiants

### Étape 1 : Créer la classe Personnage
- Définir les attributs
- Créer le constructeur
- Implémenter attaquer()
- Tester avec deux personnages simples

---

### Étape 2 : Créer la classe Joueur
- Créer le tableau de 3 personnages
- Ajouter une méthode pour afficher l'équipe
- Ajouter une méthode pour vérifier s’il reste un personnage vivant

---

### Étape 3 : Créer la logique du jeu
- Utiliser Scanner
- Gérer la boucle de tours
- Permettre à l’utilisateur de choisir des personnages par numéro

---

## ✅ Conditions de réussite

Le jeu est considéré comme fonctionnel si :
- Le joueur peut créer ses personnages
- Les combats se déroulent sans bug
- Le jeu annonce le vainqueur
- Les personnages morts ne peuvent plus jouer

---

## 🏁 Fin du jeu

Quand un joueur n'a plus de personnages vivants :

```
Victoire de Alice ! Tous les personnages de Bob sont éliminés.
```

---

## 💡 Extensions possibles (facultatif)
- Ajouter des soins
- Ajouter un système de critique
- Différents types de personnages
- Points d'expérience
- Niveaux

---

