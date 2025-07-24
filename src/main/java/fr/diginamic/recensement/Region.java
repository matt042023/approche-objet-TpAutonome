package fr.diginamic.recensement;

public class Region {
    private String code;
    private String nom;
    private int populationTotale;

    public Region(String code, String nom) {
        this.code = code;
        this.nom = nom;
        this.populationTotale = 0;
    }

    public void ajouterPopulation(int population) {
        this.populationTotale += population;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    @Override
    public String toString() {
        return nom + " (" + code + ") - " + populationTotale + " habitants";
    }
}
