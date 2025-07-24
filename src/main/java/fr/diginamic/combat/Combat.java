package fr.diginamic.combat;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe gérant la logique de combat entre le personnage et les créatures.
 * 
 * Cette classe implémente les règles de combat selon l'énoncé :
 * - Combat au tour par tour
 * - Calcul d'attaque (force + facteur aléatoire 1-10)
 * - Celui avec la plus forte attaque gagne le tour
 * - Dégâts = différence entre les deux attaques
 * - Combat jusqu'à la mort d'un protagoniste
 *
 */
public class Combat {
    
    /**
     * Lance un combat entre le personnage et une créature.
     * 
     * Gère l'intégralité du déroulement du combat selon les règles :
     * - Affichage des statistiques initiales
     * - Boucle de combat tour par tour
     * - Calcul des attaques et résolution
     * - Attribution des récompenses en cas de victoire
     * 
     * @param perso Le personnage joueur
     * @param creature La créature à combattre
     * @return true si le personnage gagne, false s'il perd
     */
    public static boolean lancerCombat(Personnage perso, Creature creature) {
        Scanner scanner = new Scanner(System.in);
        
        // Affichage de l'en-tête de combat
        System.out.println("⚔️ Combat contre un " + creature.getNom() + " !");
        System.out.println("═".repeat(60));
        afficherStatsCombat(perso, creature);
        
        int tour = 1;
        
        // Boucle principale de combat - continue tant que les deux protagonistes sont vivants
        while (perso.estVivant() && creature.estVivant()) {
            System.out.println("\n🔄 TOUR " + tour++);
            System.out.println("═".repeat(60));
            
            // ========== PHASE 1: CALCUL DES ATTAQUES ==========
            // Chaque protagoniste calcule son attaque selon les règles
            int attaquePersonnage = perso.attaquer();
            int attaqueCreature = creature.attaquer();
            
            // Affichage des jets d'attaque
            System.out.println("🎲 Votre jet d'attaque: " + attaquePersonnage);
            System.out.println("🎲 " + creature.getNom() + " lance une attaque: " + attaqueCreature);
            
            // ========== PHASE 2: RÉSOLUTION DU TOUR ==========
            // Comparaison des attaques pour déterminer le vainqueur du tour
            if (attaquePersonnage > attaqueCreature) {
                // VICTOIRE DU PERSONNAGE
                int degats = attaquePersonnage - attaqueCreature;
                creature.appliquerDegats(degats);
                System.out.println("✅ Vous remportez ce tour !");
                System.out.println("⚔️ Vous infligez " + degats + " dégâts à " + creature.getNom() + " !");
                
                // Vérification si la créature est vaincue
                if (!creature.estVivant()) {
                    System.out.println("💀 " + creature.getNom() + " est vaincu !");
                }
                
            } else if (attaqueCreature > attaquePersonnage) {
                // VICTOIRE DE LA CRÉATURE
                int degats = attaqueCreature - attaquePersonnage;
                perso.appliquerDegats(degats);
                System.out.println("❌ " + creature.getNom() + " remporte ce tour !");
                System.out.println("💥 " + creature.getNom() + " vous inflige " + degats + " dégâts !");
                
                // Vérification si le personnage est vaincu
                if (!perso.estVivant()) {
                    System.out.println("💀 Vous êtes vaincu !");
                }
                
            } else {
                // ÉGALITÉ - aucun dégât infligé
                System.out.println("⚖️ Égalité ! Aucun dégât infligé ce tour.");
            }
            
            // ========== PHASE 3: MISE À JOUR ==========
            // Affichage des statistiques après le tour
            afficherStatsCombat(perso, creature);
            
            // Gestion des effets temporaires du personnage (bonus d'attaque)
            perso.tourSuivant();
            
            // Pause interactive avant le prochain tour (si combat continue)
            if (perso.estVivant() && creature.estVivant()) {
                System.out.print("\n⏳ Appuyez sur Entrée pour continuer...");
                scanner.nextLine();
            }
        }

        // ========== RÉSOLUTION FINALE DU COMBAT ==========
        if (perso.estVivant()) {
            // VICTOIRE DU PERSONNAGE
            System.out.println("✅ Victoire !");
            
            // Attribution du score basé sur le type de créature vaincue
            int gainScore = switch (creature.getClass().getSimpleName()) {
                case "Loup" -> 1;      // Créature faible = 1 point
                case "Gobelin" -> 2;   // Créature moyenne = 2 points
                case "Troll" -> 5;     // Créature forte = 5 points
                default -> 0;          // Sécurité (ne devrait pas arriver)
            };
            perso.ajouterScore(gainScore);
            System.out.println("🏆 Vous gagnez " + gainScore + " point(s) ! Score total: " + perso.getScore());
            
            // Chance d'obtenir une récompense supplémentaire
            donnerRecompense(perso);
            return true;
            
        } else {
            // DÉFAITE DU PERSONNAGE
            System.out.println("💀 Vous êtes mort. Score final : " + perso.getScore());
            return false;
        }
    }

    /**
     * Gère l'attribution aléatoire d'une récompense après une victoire.
     * 
     * Selon les règles, le personnage a 50% de chance d'obtenir une récompense
     * parmi 4 possibilités équiprobables :
     * - Potion de soin
     * - Potion d'attaque mineure  
     * - Potion d'attaque majeure
     * - Bonus de 5 points au score
     * 
     * @param personnage Le personnage qui recevra la récompense
     */
    private static void donnerRecompense(Personnage personnage) {
        Random rand = new Random();
        
        // Test de la probabilité de 50% d'obtenir une récompense
        if (rand.nextBoolean()) {
            // Sélection aléatoire du type de récompense (0-3)
            int typeRecompense = rand.nextInt(4);
            
            switch (typeRecompense) {
                case 0 -> {
                    // Récompense : Potion de soin
                    personnage.ajouterPotion(new PotionSoin());
                    System.out.println("🎁 Vous trouvez une Potion de Soin !");
                }
                case 1 -> {
                    // Récompense : Potion d'attaque mineure
                    personnage.ajouterPotion(new PotionAttaqueMineure());
                    System.out.println("🎁 Vous trouvez une Potion d'Attaque Mineure !");
                }
                case 2 -> {
                    // Récompense : Potion d'attaque majeure
                    personnage.ajouterPotion(new PotionAttaqueMajeure());
                    System.out.println("🎁 Vous trouvez une Potion d'Attaque Majeure !");
                }
                case 3 -> {
                    // Récompense : Bonus de score
                    personnage.ajouterScore(5);
                    System.out.println("🎁 Bonus de 5 points au score !");
                }
            }
        } else {
            // Pas de chance cette fois
            System.out.println("🚫 Pas de récompense cette fois...");
        }
    }

    private static String choisirAction(Scanner scanner, Personnage personnage) {
        while (true) {
            System.out.println("🎯 QUE VOULEZ-VOUS FAIRE ?");
            System.out.println("-".repeat(30));
            System.out.println("1. ⚔️ Attaquer");
            System.out.println("2. 🏃 Fuir le combat");
            System.out.print("➤ Votre choix: ");
            
            String choix = scanner.nextLine();
            
            switch (choix) {
                case "1" -> {
                    return "ATTAQUER";
                }
                case "2" -> {
                    System.out.print("❓ Êtes-vous sûr de vouloir fuir ? (o/n): ");
                    String confirmation = scanner.nextLine().toLowerCase();
                    if (confirmation.equals("o") || confirmation.equals("oui")) {
                        return "FUIR";
                    }
                }
                default -> System.out.println("❌ Choix invalide ! Choisissez 1 ou 2.");
            }
        }
    }

    private static boolean utiliserPotionCombat(Scanner scanner, Personnage personnage) {
        System.out.println("\n🧪 POTIONS DISPONIBLES:");
        System.out.println("-".repeat(40));
        
        for (int i = 0; i < personnage.getInventaire().size(); i++) {
            System.out.println((i + 1) + ". " + personnage.getInventaire().get(i).getNom());
        }
        System.out.println("0. ↩️ Annuler");
        System.out.print("➤ Choisissez une potion: ");
        
        try {
            int choixPotion = Integer.parseInt(scanner.nextLine());
            
            if (choixPotion == 0) {
                return false; // Annulé
            }
            
            if (choixPotion < 1 || choixPotion > personnage.getInventaire().size()) {
                System.out.println("❌ Choix invalide !");
                return false;
            }
            
            Potion potion = personnage.getInventaire().remove(choixPotion - 1);
            potion.appliquer(personnage);
            System.out.println("✅ Potion utilisée !");
            return true;
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Veuillez entrer un nombre valide !");
            return false;
        }
    }

    /**
     * Affiche les statistiques actuelles des deux combattants.
     * 
     * Utilisée pour tenir le joueur informé de l'état du combat
     * à chaque tour.
     * 
     * @param perso Le personnage joueur
     * @param creature La créature adversaire
     */
    private static void afficherStatsCombat(Personnage perso, Creature creature) {
        System.out.println("📊 ÉTAT DU COMBAT");
        System.out.println("-".repeat(40));
        
        // Affichage des statistiques complètes du personnage
        System.out.println("👤 " + perso.getStatuts());
        
        // Affichage des statistiques de la créature (nom + santé)
        System.out.println("👹 " + creature.getNom() + " - Santé: " + creature.getSante() + " PV");
    }

}
