package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.List;
import java.util.Scanner;

/**
 * Service : Affiche la population d'une ville saisie par l’utilisateur.
 */
public class RecherchePopulationVille extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("🔎 Entrez le nom de la ville : ");
        String nomVille = scanner.nextLine().trim().toLowerCase();

        List<Ville> villes = recensement.getVilles();
        boolean trouvee = false;

        for (Ville ville : villes) {
            if (ville.getNomCommune().trim().toLowerCase().equals(nomVille)) {
                System.out.println("✅ Population de " + ville.getNomCommune() + " : " + ville.getPopulationTotale() + " habitants");
                trouvee = true;
                break;
            }
        }

        if (!trouvee) {
            System.out.println("❌ Ville introuvable dans le recensement.");
        }
    }
}
