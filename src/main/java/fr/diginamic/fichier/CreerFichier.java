package fr.diginamic.fichier;

import java.io.*;

public class CreerFichier {
    public static void main(String[] args) {
        String cheminFichier = "src/main/resources/recensement.csv";
        String cheminDestination = "src/main/resources/recensement_100.csv";

        int ligneMax = 100;
        int compteur = 0;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
                BufferedWriter writer = new BufferedWriter(new FileWriter(cheminDestination))
                ) {
            String ligne;

            while((ligne = reader.readLine()) != null && compteur < ligneMax) {
                writer.write(ligne);
                writer.newLine();
                compteur++;
            }

            System.out.println("Fichier généré avec succès : " + cheminDestination);
        } catch (IOException e) {
            System.err.println("Erruer lors de la lecture ou écriture");
        }
    }
}
