package fr.diginamic.essais;

import fr.diginamic.maison.*;

public class TestMaison {
    public static void main(String[] args) {

        Maison maison = new Maison();

        maison.ajouterPiece(new Chambre(12.5, 0));
        maison.ajouterPiece(new Cuisine(10, 0));
        maison.ajouterPiece(new Salon(25, 0));
        maison.ajouterPiece(new SalleDeBain(8, 1));
        maison.ajouterPiece(new Chambre(13, 1));
        maison.ajouterPiece(new WC(2, 1));

        // Tests invalides
        maison.ajouterPiece(null); // pièce null
        maison.ajouterPiece(new Chambre(-10, 1)); // superficie négative
        maison.ajouterPiece(new WC(3, -1)); // étage négatif

        // Résultats
        System.out.println("Superficie totale : " + maison.superficieTotale() + " m²");
        System.out.println("Superficie étage 0 : " + maison.superficieEtage(0) + " m²");
        System.out.println("Superficie étage 1 : " + maison.superficieEtage(1) + " m²");

        System.out.println("Superficie totale des chambres : " + maison.superficieType(Chambre.class) + " m²");
        System.out.println("Nombre de chambres : " + maison.nombrePiecesType(Chambre.class));

        System.out.println("Nombre de WC : " + maison.nombrePiecesType(WC.class));
    }
}
