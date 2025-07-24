package fr.diginamic.recensement;

public class Departement {
    private String code;
    private int populationTotale;

    public Departement(String code) {
        this.code = code;
        this.populationTotale = 0;
    }

    public void ajouterPopulation(int population) {
        this.populationTotale += population;
    }

    public String getCode() {
        return code;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    @Override
    public String toString() {
        return "Département " + code + " - " + populationTotale + " habitants";
    }
}
