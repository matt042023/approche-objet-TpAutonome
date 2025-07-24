package fr.diginamic.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Représente le personnage joueur dans le jeu de combat RPG.
 * 
 * Le personnage possède des caractéristiques (force, santé) générées aléatoirement
 * lors de sa création, un système de score pour mesurer ses performances, et un
 * inventaire de potions pour l'aider dans ses combats.
 * 
 * Caractéristiques initiales :
 * - Force : entre 12 et 18 (générée aléatoirement)
 * - Santé : entre 20 et 50 (générée aléatoirement) 
 * - Score : 0
 * - Inventaire : 3 potions de départ (soin, attaque mineure, robustesse)
 *
 */
public class Personnage {
    /** Force du personnage, détermine sa puissance d'attaque de base */
    private int force;
    
    /** Points de santé actuels du personnage */
    private int sante;
    
    /** Points de santé maximum du personnage (peut être augmenté par des potions) */
    private int santeMax;
    
    /** Score accumulé par le personnage (victoires contre les créatures) */
    private int score;
    
    /** Inventaire des potions possédées par le personnage */
    private List<Potion> inventaire = new ArrayList<>();
    
    /** Bonus d'attaque temporaire (accordé par les potions d'attaque) */
    private int bonusAttaque = 0;
    
    /** Nombre de combats restants pour le bonus d'attaque */
    private int dureeBonus = 0;

    /**
     * Constructeur du personnage.
     * 
     * Génère automatiquement les caractéristiques du personnage selon les règles :
     * - Force entre 12 et 18
     * - Santé entre 20 et 50
     * - Score à 0
     * - Inventaire avec 3 potions de départ
     */
    public Personnage() {
        Random rand = new Random();
        
        // Génération aléatoire de la force (12-18)
        this.force = 12 + rand.nextInt(7);
        
        // Génération aléatoire de la santé (20-50)
        this.sante = 20 + rand.nextInt(31);
        
        // Santé maximum égale à la santé initiale
        this.santeMax = this.sante;
        
        // Score initial à zéro
        this.score = 0;
        
        // Ajout des potions de départ selon les règles
        ajouterPotion(new PotionSoin());
        ajouterPotion(new PotionAttaqueMineure());
        ajouterPotion(new PotionRobustesse());
    }



    /**
     * Ajoute une potion à l'inventaire du personnage.
     * 
     * @param potion La potion à ajouter à l'inventaire
     */
    public void ajouterPotion(Potion potion) {
        inventaire.add(potion);
    }

    /**
     * Calcule la valeur d'attaque du personnage pour un tour de combat.
     * 
     * L'attaque est composée de :
     * - La force de base du personnage
     * - Le bonus d'attaque temporaire (si actif)
     * - Un facteur aléatoire entre 1 et 10
     * 
     * @return La valeur d'attaque calculée
     */
    public int attaquer() {
        Random rand = new Random();
        // Calcul selon les règles : force + bonus + aléatoire(1-10)
        int attaque = force + bonusAttaque + (1 + rand.nextInt(10));
        return attaque;
    }

    /**
     * Applique des dégâts au personnage en réduisant sa santé.
     * 
     * @param degats Le nombre de points de dégâts à appliquer
     */
    public void appliquerDegats(int degats) {
        sante -= degats;
    }

    /**
     * Gère la fin d'un tour de combat pour le personnage.
     * 
     * Décrémente la durée des bonus d'attaque et les supprime
     * quand ils arrivent à expiration.
     */
    public void tourSuivant() {
        if (dureeBonus > 0) {
            dureeBonus--;
            // Suppression du bonus quand la durée expire
            if (dureeBonus == 0) {
                bonusAttaque = 0;
            }
        }
    }

    /**
     * Vérifie si le personnage est encore en vie.
     * 
     * @return true si la santé est supérieure à 0, false sinon
     */
    public boolean estVivant() {
        return sante > 0;
    }

    /**
     * Ajoute des points de santé au personnage sans dépasser la santé maximum.
     * 
     * Utilisée principalement par les potions de soin.
     * 
     * @param points Le nombre de points de santé à ajouter
     */
    public void ajouterSante(int points) {
        // Utilisation de Math.min pour ne pas dépasser la santé maximum
        this.sante = Math.min(sante + points, santeMax);
    }

    /**
     * Augmente la santé maximum du personnage et donne un bonus immédiat.
     * 
     * Utilisée par les potions de robustesse.
     * 
     * @param points Le nombre de points à ajouter à la santé maximum
     */
    public void ajouterSanteMax(int points) {
        this.santeMax += points;
        this.sante += points; // Bonus de santé immédiat
    }

    /**
     * Ajoute des points au score du personnage.
     * 
     * @param pts Le nombre de points à ajouter
     */
    public void ajouterScore(int pts) {
        score += pts;
    }

    /**
     * Définit un bonus d'attaque temporaire.
     * 
     * @param bonus La valeur du bonus d'attaque
     */
    public void setBonusAttaque(int bonus) {
        this.bonusAttaque = bonus;
    }

    /**
     * Définit la durée du bonus d'attaque en nombre de combats.
     * 
     * @param duree Le nombre de combats pendant lesquels le bonus sera actif
     */
    public void setDureeBonus(int duree) {
        this.dureeBonus = duree;
    }

    // ========== GETTERS ==========
    
    /**
     * @return Les points de santé actuels du personnage
     */
    public int getSante() {
        return sante;
    }

    /**
     * @return Les points de santé maximum du personnage
     */
    public int getSanteMax() {
        return santeMax;
    }

    /**
     * @return La force du personnage
     */
    public int getForce() {
        return force;
    }

    /**
     * @return Le score actuel du personnage
     */
    public int getScore() {
        return score;
    }

    /**
     * @return L'inventaire des potions du personnage
     */
    public List<Potion> getInventaire() {
        return inventaire;
    }

    /**
     * Génère une chaîne de caractères décrivant l'état actuel du personnage.
     * 
     * Inclut la santé, la force, les bonus actifs et le score.
     * 
     * @return Une chaîne formatée avec les statistiques du personnage
     */
    public String getStatuts() {
        StringBuilder sb = new StringBuilder();
        
        // Statistiques de base
        sb.append(String.format("❤️ Santé: %d/%d | ⚔️ Force: %d", sante, santeMax, force));
        
        // Affichage du bonus d'attaque s'il est actif
        if (bonusAttaque > 0) {
            sb.append(String.format(" (+%d pendant %d tours)", bonusAttaque, dureeBonus));
        }
        
        // Score du joueur  
        sb.append(String.format(" | 🏆 Score: %d", score));
        
        return sb.toString();
    }
}
