package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Departement;
import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.*;

/**
 * Service : Affiche les 10 départements les plus peuplés.
 */
public class Top10DepartementsPop extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        Map<String, Departement> departements = new HashMap<>();

        for (Ville ville : recensement.getVilles()) {
            String code = ville.getCodeDepartement();
            int pop = ville.getPopulationTotale();

            departements
                    .computeIfAbsent(code, Departement::new)
                    .ajouterPopulation(pop);
        }

        // Tri des départements par population décroissante
        List<Departement> listeDep = new ArrayList<>(departements.values());
        listeDep.sort((d1, d2) -> Integer.compare(d2.getPopulationTotale(), d1.getPopulationTotale()));

        // Affichage des 10 premiers
        System.out.println("🏆 Top 10 des départements les plus peuplés :");
        for (int i = 0; i < Math.min(10, listeDep.size()); i++) {
            Departement dep = listeDep.get(i);
            System.out.printf("%d. Département %s - %d habitants%n", i + 1, dep.getCode(), dep.getPopulationTotale());
        }
    }
}
