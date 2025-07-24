package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.List;
import java.util.Scanner;

/**
 * Service : Calcule la population d’un département donné.
 */
public class RecherchePopulationDepartement extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("🔎 Entrez le code du département : ");
        String codeDepartement = scanner.nextLine().trim();

        List<Ville> villes = recensement.getVilles();
        int populationTotale = 0;
        boolean trouve = false;

        for (Ville ville : villes) {
            if (ville.getCodeDepartement().equalsIgnoreCase(codeDepartement)) {
                populationTotale += ville.getPopulationTotale();
                trouve = true;
            }
        }

        if (trouve) {
            System.out.println("✅ Population totale du département " + codeDepartement + " : " + populationTotale + " habitants");
        } else {
            System.out.println("❌ Aucun département trouvé avec le code : " + codeDepartement);
        }
    }
}
