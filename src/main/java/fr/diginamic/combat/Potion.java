package fr.diginamic.combat;

/**
 * Interface définissant le comportement commun de toutes les potions du jeu.
 * 
 * Une potion doit pouvoir :
 * - Fournir son nom pour l'affichage dans l'inventaire
 * - S'appliquer sur un personnage pour produire son effet
 * 
 * Les potions peuvent avoir des effets variés :
 * - Restauration de santé (PotionSoin)
 * - Augmentation temporaire d'attaque (PotionAttaqueMineure/Majeure)
 * - Amélioration permanente de la robustesse (PotionRobustesse)
 *
 */
public interface Potion {
    
    /**
     * Retourne le nom descriptif de la potion.
     * 
     * Utilisé pour l'affichage dans l'inventaire et les menus.
     * 
     * @return Le nom de la potion avec sa description d'effet
     */
    String getNom();
    
    /**
     * Applique l'effet de la potion sur le personnage donné.
     * 
     * Cette méthode modifie les caractéristiques du personnage
     * selon l'effet spécifique de la potion.
     * 
     * @param personnage Le personnage sur lequel appliquer l'effet
     */
    void appliquer(Personnage personnage);
}
