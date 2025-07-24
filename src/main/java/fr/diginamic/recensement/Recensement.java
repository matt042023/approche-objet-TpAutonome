package fr.diginamic.recensement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente l’ensemble des données de recensement, via une liste de villes.
 */
public class Recensement {
    private List<Ville> villes = new ArrayList<>();

    public List<Ville> getVilles() {
        return villes;
    }

    /**
     * Charge les données du fichier CSV en mémoire.
     * @param cheminFichier Chemin vers le fichier de recensement
     */
    public void charger(String cheminFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int ligneActuelle = 0;

            while ((ligne = reader.readLine()) != null) {
                ligneActuelle++;

                // Ignorer l'en-tête
                if (ligneActuelle == 1) {
                    continue;
                }

                String[] tokens = ligne.split(";");
                if (tokens.length < 10) {
                    System.err.println("⚠️ Ligne ignorée (format incorrect) : " + ligne);
                    continue;
                }

                try {
                    String codeRegion = tokens[0].trim();
                    String nomRegion = tokens[1].trim();
                    String codeDepartement = tokens[2].trim();
                    String codeCommune = tokens[5].trim();
                    String nomCommune = tokens[6].trim();
                    int populationTotale = Integer.parseInt(tokens[9].trim().replaceAll(" ", ""));

                    Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);
                    villes.add(ville);

                } catch (NumberFormatException e) {
                    System.err.println("⚠️ Erreur de parsing population ligne " + ligneActuelle + " : " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("❌ Erreur de lecture du fichier : " + e.getMessage());
        }

        System.out.println("✅ Chargement terminé. Villes chargées : " + villes.size());
    }
}
