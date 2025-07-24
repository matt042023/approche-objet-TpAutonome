package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service : Affiche les 10 villes les plus peuplées d’une région.
 */
public class Top10VillesRegion extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("🔎 Entrez le nom de la région : ");
        String nomRegion = scanner.nextLine().trim().toLowerCase();

        List<Ville> villesFiltrees = recensement.getVilles().stream()
                .filter(v -> v.getNomRegion().trim().toLowerCase().equals(nomRegion))
                .sorted(Comparator.comparingInt(Ville::getPopulationTotale).reversed())
                .limit(10)
                .collect(Collectors.toList());

        if (villesFiltrees.isEmpty()) {
            System.out.println("❌ Aucune ville trouvée pour la région : " + nomRegion);
            return;
        }

        System.out.println("🏙️ Top 10 des villes de la région " + villesFiltrees.get(0).getNomRegion() + " :");
        int rang = 1;
        for (Ville ville : villesFiltrees) {
            System.out.printf("%d. %s - %d habitants%n", rang++, ville.getNomCommune(), ville.getPopulationTotale());
        }
    }
}
