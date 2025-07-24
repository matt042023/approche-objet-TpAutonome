package fr.diginamic.combat;

import java.util.Random;

/**
 * Représente un Troll, créature de niveau élevé dans le bestiaire.
 * 
 * Caractéristiques selon les règles :
 * - Force : entre 10 et 15
 * - Santé : entre 20 et 30
 * - Récompense si vaincu : +5 points de score
 * 
 * Le Troll est la créature la plus puissante du jeu, offrant
 * le défi le plus important mais aussi la meilleure récompense.
 *
 */
public class Troll extends Creature {
    /**
     * Constructeur du Troll.
     * 
     * Génère aléatoirement les caractéristiques selon les règles :
     * - Force entre 10 et 15
     * - Santé entre 20 et 30
     */
    public Troll() {
        Random rand = new Random();
        
        // Génération aléatoire de la force (10-15)
        this.force = 10 + rand.nextInt(6);
        
        // Génération aléatoire de la santé (20-30)
        this.sante = 20 + rand.nextInt(11);
    }

    /**
     * @return "Troll"
     */
    @Override
    public String getNom() {
        return "Troll";
    }
}
