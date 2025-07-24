package fr.diginamic.entites;

public class Theatre {
    private String nom;
    private int capaciteMax;
    private int totalClients;
    private double recette;

    public Theatre(String nom, int capaciteMax) {
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.totalClients = 0;
        this.recette = 0;
    }

    public void inscrire(int nbClients, double prixPlace) throws Exception {
        int capaciteRestante = capaciteMax - totalClients;
        if (nbClients > capaciteRestante) {
            throw new Exception("Le theatre n'est pas en mesure d'accueillir " + nbClients  + " personnes .\n"+ capaciteRestante + " places restantes.");
        }
        totalClients += nbClients;
        recette += nbClients * prixPlace;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "nom='" + nom + '\'' +
                ", capacite=" + capaciteMax +
                ", inscrits=" + totalClients +
                ", recette=" + recette +
                '}';
    }
}
