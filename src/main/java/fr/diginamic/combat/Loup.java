package fr.diginamic.combat;

import java.util.Random;

/**
 * Représente un Loup, créature de niveau faible dans le bestiaire.
 * 
 * Caractéristiques selon les règles :
 * - Force : entre 3 et 8
 * - Santé : entre 5 et 10  
 * - Récompense si vaincu : +1 point de score
 * 
 * Le Loup est la créature la plus faible mais aussi la plus accessible
 * pour les personnages débutants.
 *
 */
public class Loup extends Creature {
    /**
     * Constructeur du Loup.
     * 
     * Génère aléatoirement les caractéristiques selon les règles :
     * - Force entre 3 et 8
     * - Santé entre 5 et 10
     */
    public Loup() {
        Random rand = new Random();
        
        // Génération aléatoire de la force (3-8)
        this.force = 3 + rand.nextInt(6);
        
        // Génération aléatoire de la santé (5-10)
        this.sante = 5 + rand.nextInt(6);
    }

    /**
     * @return "Loup"
     */
    @Override
    public String getNom() {
        return "Loup";
    }
}
