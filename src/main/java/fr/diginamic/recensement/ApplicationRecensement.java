package fr.diginamic.recensement;

import fr.diginamic.recensement.services.*;

import java.util.Scanner;

/**
 * Application console principale pour interroger les données de recensement.
 */
public class ApplicationRecensement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chargement des données
        Recensement recensement = new Recensement();
        recensement.charger("src/main/resources/recensement.csv");

        // Boucle de menu
        boolean continuer = true;

        while (continuer) {
            afficherMenu();

            System.out.print("➡️ Entrez votre choix : ");
            String choix = scanner.nextLine();

            MenuService service = null;

            switch (choix) {
                case "1":
                    service = new RecherchePopulationVille();
                    break;
                case "2":
                    service = new RecherchePopulationDepartement();
                    break;
                case "3":
                    service = new RecherchePopulationRegion();
                    break;
                case "4":
                    service = new Top10RegionsPop();
                    break;
                case "5":
                    service = new Top10DepartementsPop();
                    break;
                case "6":
                    service = new Top10VillesDepartement();
                    break;
                case "7":
                    service = new Top10VillesRegion();
                    break;
                case "8":
                    service = new Top10VillesFrance();
                    break;
                case "9":
                    continuer = false;
                    System.out.println("👋 Fin de l’application.");
                    break;
                default:
                    System.out.println("❌ Choix invalide. Veuillez réessayer.");
                    break;
            }

            if (service != null) {
                service.traiter(recensement, scanner);
            }

            System.out.println(); // Ligne vide pour lisibilité
        }

        scanner.close();
    }

    /**
     * Affiche le menu utilisateur.
     */
    private static void afficherMenu() {
        System.out.println("------------ MENU -------------");
        System.out.println("1. Population d’une ville donnée");
        System.out.println("2. Population d’un département donné");
        System.out.println("3. Population d’une région donnée");
        System.out.println("4. Afficher les 10 régions les plus peuplées");
        System.out.println("5. Afficher les 10 départements les plus peuplés");
        System.out.println("6. Afficher les 10 villes les plus peuplées d’un département");
        System.out.println("7. Afficher les 10 villes les plus peuplées d’une région");
        System.out.println("8. Afficher les 10 villes les plus peuplées de France");
        System.out.println("9. Sortir");
        System.out.println("-------------------------------");
    }
}
