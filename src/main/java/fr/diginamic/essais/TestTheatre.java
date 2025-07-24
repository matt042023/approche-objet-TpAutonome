package fr.diginamic.essais;

import fr.diginamic.entites.Theatre;

public class TestTheatre {
    public static void main(String[] args) {

        Theatre theatre = new Theatre("La Belle Etoile", 100);

        try {
            theatre.inscrire(25,50);
            theatre.inscrire(55,50);
            theatre.inscrire(12,50);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println(theatre);

        try {
            theatre.inscrire(45, 100);
        }catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }


    }
}
