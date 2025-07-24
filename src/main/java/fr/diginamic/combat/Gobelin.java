package fr.diginamic.combat;

import java.util.Random;

/**
 * Représente un Gobelin, créature de niveau intermédiaire dans le bestiaire.
 * 
 * Caractéristiques selon les règles :
 * - Force : entre 5 et 10
 * - Santé : entre 10 et 15
 * - Récompense si vaincu : +2 points de score
 * 
 * Le Gobelin représente un défi modéré avec des statistiques
 * équilibrées entre le Loup et le Troll.
 *
 */
public class Gobelin extends Creature {
    /**
     * Constructeur du Gobelin.
     * 
     * Génère aléatoirement les caractéristiques selon les règles :
     * - Force entre 5 et 10
     * - Santé entre 10 et 15
     */
    public Gobelin() {
        Random rand = new Random();
        
        // Génération aléatoire de la force (5-10)
        this.force = 5 + rand.nextInt(6);
        
        // Génération aléatoire de la santé (10-15)
        this.sante = 10 + rand.nextInt(6);
    }

    /**
     * @return "Gobelin"
     */
    @Override
    public String getNom() {
        return "Gobelin";
    }
}
