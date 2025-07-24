// fr.diginamic.combat.Jeu
package fr.diginamic.combat;

import java.util.Scanner;

public class Jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personnage personnage = null;
        boolean enCours = true;

        while (enCours) {
            System.out.println("\n" + "═".repeat(60));
            System.out.println("🎮 JEU DE COMBAT RPG");
            if (personnage != null) {
                System.out.println("👤 " + personnage.getStatuts());
                System.out.println("🎒 Potions: " + personnage.getInventaire().size());
            }
            System.out.println("═".repeat(60));
            System.out.println("""
                🎯 MENU PRINCIPAL
                1. 👤 Créer un personnage
                2. ⚔️ Combattre une créature
                3. 🧪 Prendre une potion
                4. 🏆 Afficher le score
                5. 🚪 Quitter
            """);
            System.out.print("➤ Votre choix: ");

            String choix = scanner.nextLine();

            switch (choix) {
                case "1" -> {
                    personnage = new Personnage();
                    System.out.println("\n🎉 NOUVEAU PERSONNAGE CRÉÉ !");
                    System.out.println("═".repeat(40));
                    System.out.println("👤 " + personnage.getStatuts());
                    System.out.println("🎒 Inventaire de départ:");
                    for (int i = 0; i < personnage.getInventaire().size(); i++) {
                        System.out.println("  • " + personnage.getInventaire().get(i).getNom());
                    }
                    System.out.println("🚀 Prêt pour l'aventure !");
                }
                case "2" -> {
                    if (personnage == null) {
                        System.out.println("⛔ Créez d'abord un personnage !");
                        break;
                    }
                    if (!personnage.estVivant()) {
                        System.out.println("💀 Votre personnage est décédé. Il a obtenu le score de " + 
                                         personnage.getScore() + " points. Veuillez créer un nouveau personnage.");
                        break;
                    }
                    Creature creature = switch ((int) (Math.random() * 3)) {
                        case 0 -> new Loup();
                        case 1 -> new Gobelin();
                        case 2 -> new Troll();
                        default -> null;
                    };
                    Combat.lancerCombat(personnage, creature);
                }
                case "3" -> {
                    if (personnage == null) {
                        System.out.println("⛔ Créez d'abord un personnage !");
                        break;
                    }
                    
                    if (personnage.getInventaire().isEmpty()) {
                        System.out.println("🎒 Votre inventaire est vide !");
                        break;
                    }
                    
                    System.out.println("\n🧪 POTIONS DISPONIBLES:");
                    System.out.println("-".repeat(40));
                    for (int i = 0; i < personnage.getInventaire().size(); i++) {
                        System.out.println((i + 1) + ". " + personnage.getInventaire().get(i).getNom());
                    }
                    System.out.println("0. ↩️ Retour au menu");
                    System.out.print("➤ Choisissez une potion: ");
                    
                    try {
                        int choixPotion = Integer.parseInt(scanner.nextLine());
                        
                        if (choixPotion == 0) {
                            break; // Retour au menu
                        }
                        
                        if (choixPotion < 1 || choixPotion > personnage.getInventaire().size()) {
                            System.out.println("❌ Choix invalide ! Sélectionnez entre 1 et " + personnage.getInventaire().size());
                            break;
                        }
                        
                        Potion potion = personnage.getInventaire().remove(choixPotion - 1);
                        potion.appliquer(personnage);
                        System.out.println("✅ Potion utilisée avec succès !");
                        
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Veuillez entrer un nombre valide !");
                    }
                }
                case "4" -> {
                    if (personnage == null) {
                        System.out.println("⛔ Créez d'abord un personnage !");
                    } else {
                        System.out.println("\n📊 STATISTIQUES DU PERSONNAGE");
                        System.out.println("═".repeat(40));
                        System.out.println(personnage.getStatuts());
                        System.out.println("🎒 Potions en possession: " + personnage.getInventaire().size());
                        System.out.println("🏆 Score actuel: " + personnage.getScore() + " points");
                        
                        if (personnage.estVivant()) {
                            System.out.println("💚 Statut: En vie");
                        } else {
                            System.out.println("💀 Statut: Décédé");
                        }
                    }
                }
                case "5" -> enCours = false;
                default -> System.out.println("❌ Option invalide");
            }
        }

        scanner.close();
        System.out.println("👋 Fin du jeu.");
    }
}
