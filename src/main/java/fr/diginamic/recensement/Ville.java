package fr.diginamic.recensement;

/**
 * Représente une ville issue du fichier de recensement.
 */
public class Ville {
    private String codeRegion;
    private String nomRegion;
    private String codeDepartement;
    private String codeCommune;
    private String nomCommune;
    private int populationTotale;

    public Ville(String codeRegion, String nomRegion, String codeDepartement,
                 String codeCommune, String nomCommune, int populationTotale) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.codeDepartement = codeDepartement;
        this.codeCommune = codeCommune;
        this.nomCommune = nomCommune;
        this.populationTotale = populationTotale;
    }

    // Getters
    public String getCodeRegion() {
        return codeRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public String getCodeCommune() {
        return codeCommune;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    @Override
    public String toString() {
        return nomCommune + " (" + codeDepartement + ", " + nomRegion + ") - " + populationTotale + " habitants";
    }
}