package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Region;
import fr.diginamic.recensement.Ville;

import java.util.*;

/**
 * Service : Affiche les 10 régions les plus peuplées.
 */
public class Top10RegionsPop extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        Map<String, Region> regions = new HashMap<>();

        for (Ville ville : recensement.getVilles()) {
            String code = ville.getCodeRegion();
            String nom = ville.getNomRegion();
            int pop = ville.getPopulationTotale();

            // Si la région existe déjà → ajout population
            if (regions.containsKey(code)) {
                regions.get(code).ajouterPopulation(pop);
            } else {
                // Sinon → création
                Region region = new Region(code, nom);
                region.ajouterPopulation(pop);
                regions.put(code, region);
            }
        }

        // Tri des régions par population décroissante
        List<Region> listeRegions = new ArrayList<>(regions.values());
        listeRegions.sort((r1, r2) -> Integer.compare(r2.getPopulationTotale(), r1.getPopulationTotale()));

        // Affichage des 10 premières
        System.out.println("🏆 Top 10 des régions les plus peuplées :");
        for (int i = 0; i < Math.min(10, listeRegions.size()); i++) {
            Region region = listeRegions.get(i);
            System.out.printf("%d. %s - %d habitants%n", i + 1, region.getNom(), region.getPopulationTotale());
        }
    }
}
