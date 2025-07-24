package fr.diginamic.combat;

import java.util.Random;

/**
 * Classe abstraite représentant une créature dans le jeu de combat.
 * 
 * Cette classe définit les comportements de base communs à toutes les créatures :
 * - Statistiques de force et de santé
 * - Capacité d'attaque avec facteur aléatoire
 * - Gestion des dégâts et de la survie
 * 
 * Les classes dérivées doivent implémenter la méthode getNom() pour définir
 * le type spécifique de créature.
 */
public abstract class Creature {
    /** Force de la créature, détermine sa puissance d'attaque de base */
    protected int force;
    
    /** Points de santé actuels de la créature */
    protected int sante;

    /**
     * Méthode abstraite pour obtenir le nom de la créature.
     * 
     * Doit être implémentée par chaque type de créature spécifique.
     * 
     * @return Le nom de la créature (ex: "Loup", "Gobelin", "Troll")
     */
    public abstract String getNom();

    /**
     * Calcule la valeur d'attaque de la créature pour un tour de combat.
     * 
     * L'attaque suit les règles du jeu :
     * force de base + facteur aléatoire entre 1 et 10
     * 
     * @return La valeur d'attaque calculée
     */
    public int attaquer() {
        // Calcul selon les règles : force + aléatoire(1-10)
        return force + (1 + new Random().nextInt(10));
    }

    /**
     * Applique des dégâts à la créature en réduisant sa santé.
     * 
     * @param degats Le nombre de points de dégâts à appliquer
     */
    public void appliquerDegats(int degats) {
        sante -= degats;
    }

    /**
     * Vérifie si la créature est encore en vie.
     * 
     * @return true si la santé est supérieure à 0, false sinon
     */
    public boolean estVivant() {
        return sante > 0;
    }

    /**
     * @return Les points de santé actuels de la créature
     */
    public int getSante() {
        return sante;
    }
}
