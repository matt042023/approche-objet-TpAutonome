package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.List;
import java.util.Scanner;

/**
 * Service : Calcule la population d'une région donnée.
 */
public class RecherchePopulationRegion extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("🔎 Entrez le nom de la région : ");
        String nomRegion = scanner.nextLine().trim().toLowerCase();

        List<Ville> villes = recensement.getVilles();
        int populationTotale = 0;
        boolean trouve = false;

        for (Ville ville : villes) {
            if (ville.getNomRegion().trim().toLowerCase().equals(nomRegion)) {
                populationTotale += ville.getPopulationTotale();
                trouve = true;
            }
        }

        if (trouve) {
            System.out.println("✅ Population totale de la région '" + nomRegion + "' : " + populationTotale + " habitants");
        } else {
            System.out.println("❌ Région introuvable : " + nomRegion);
        }
    }
}
