package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service : Affiche les 10 villes les plus peuplées d’un département.
 */
public class Top10VillesDepartement extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("🔎 Entrez le code du département : ");
        String codeDep = scanner.nextLine().trim();

        List<Ville> villesFiltrees = recensement.getVilles().stream()
                .filter(v -> v.getCodeDepartement().equalsIgnoreCase(codeDep))
                .sorted(Comparator.comparingInt(Ville::getPopulationTotale).reversed())
                .limit(10)
                .collect(Collectors.toList());

        if (villesFiltrees.isEmpty()) {
            System.out.println("❌ Aucun résultat pour le département : " + codeDep);
            return;
        }

        System.out.println("🏙️ Top 10 des villes du département " + codeDep + " :");
        int rang = 1;
        for (Ville ville : villesFiltrees) {
            System.out.printf("%d. %s - %d habitants%n", rang++, ville.getNomCommune(), ville.getPopulationTotale());
        }
    }
}
