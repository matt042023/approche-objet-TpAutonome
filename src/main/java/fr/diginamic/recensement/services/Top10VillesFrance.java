package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Service : Affiche les 10 villes les plus peuplées de France.
 */
public class Top10VillesFrance extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        List<Ville> top10 = recensement.getVilles().stream()
                .sorted(Comparator.comparingInt(Ville::getPopulationTotale).reversed())
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("🏙️ Top 10 des villes les plus peuplées de France :");
        int rang = 1;
        for (Ville ville : top10) {
            System.out.printf("%d. %s (%s) - %d habitants%n", rang++, ville.getNomCommune(), ville.getCodeDepartement(), ville.getPopulationTotale());
        }
    }
}
