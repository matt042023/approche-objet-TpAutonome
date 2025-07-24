package fr.diginamic.chaines;

import fr.diginamic.entites.Salarie;

public class ManipulationChaine {
    public static void main(String[] args) {

        String chaine = "Durand;Marcel;2 523.5";

        // 1) Premier caractère
        char premierCaractere = chaine.charAt(0);
        System.out.println("Premier caractère : " + premierCaractere);

        // 2) Longueur de la chaîne
        int longueur = chaine.length();
        System.out.println("Longueur : " + longueur);

        // 3) Index du premier ;
        int indexPointVirgule = chaine.indexOf(';');
        System.out.println("Index du premier ';' : " + indexPointVirgule);

        // 4) Extraction du nom de famille
        String nom = chaine.substring(0, indexPointVirgule);
        System.out.println("Nom extrait : " + nom);

        // 5) Nom en majuscules
        System.out.println("Nom en MAJUSCULES : " + nom.toUpperCase());

        // 6) Nom en minuscules
        System.out.println("6Nom en minuscules : " + nom.toLowerCase());

        // 7) Découpage avec split
        String[] tabChaine = chaine.split(";");
        System.out.println("Résultat du split : ");
        for (String entree : tabChaine) {
            System.out.println("→ " + entree);
        }

        // 8 & 9) Création d'un objet Salarie à partir des morceaux
        String prenom = tabChaine[1];
        String salaireString = tabChaine[2].replace(" ", ""); // supprime l’espace
        double salaire = Double.parseDouble(salaireString);

        Salarie salarie = new Salarie(nom, prenom, salaire);

        System.out.println("Objet Salarié créé : " + salarie);
    }
}
