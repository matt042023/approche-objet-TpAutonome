package fr.diginamic.fichier;

import java.io.*;
import java.util.ArrayList;

public class LectureFichier {
    public static void main(String[] args) {
        String cheminFichier = "src/main/resources/recensement.csv";
        String cheminDestination = "src/main/resources/recensement_25000.csv";

        ArrayList<Ville> villes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))){

            String ligne;
            int ligneActuelle = 0;
            while ((ligne = reader.readLine()) != null) {
                ligneActuelle++;

                if (ligneActuelle == 1) {
                    continue;
                }

                String[] tokens = ligne.split(";");

                if (tokens.length < 10) {
                    System.err.println("Erreur de format dans la ligne " + ligneActuelle);
                    continue;
                }

                try {
                    String nomCommune = tokens[6].trim();
                    String codeDepartement = tokens[2].trim();
                    String nomRegion = tokens[1].trim();
                    String populationString = tokens[9].trim().replaceAll(" ", "");
                    int population = Integer.parseInt(populationString);

                    Ville ville = new Ville(nomCommune,codeDepartement,nomRegion,population);
                    villes.add(ville);
                }catch (NumberFormatException e) {
                    System.err.println("Erruer de conversion numérique (ligne  " + ligneActuelle + ") : " + ligne);
                } catch (Exception e) {
                    System.err.println("Erreur lors de la lecture de la ligne " + ligneActuelle + " : " + e.getMessage());
                }

            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(cheminDestination))) {
            writer.write("Nom;Code département;Nom de la Région,Population totale");
            writer.newLine();

            int grandeVille = 0;

            for (Ville ville : villes) {
                if (ville.getPopulationTotale() > 25000) {
                    String ligne = String.format("%s;%s;%s;%d", ville.getNom(), ville.getCodeDepartement(), ville.getNomRegion(), ville.getPopulationTotale());
                    writer.write(ligne);
                    writer.newLine();
                    grandeVille++;
                }
            }
            System.out.println("Total des ville de plus de 25 000 habitants : " + grandeVille + " villes") ;
        }catch (IOException e) {
            System.err.println("Erreur d'écriture du fichier : " + e.getMessage());
        }




        System.out.println("Total de villes instanciées : " + villes.size());
    }
}
