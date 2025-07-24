package fr.diginamic.operations;

import java.util.Arrays;

public class CalculMoyenne {

    private double[] valeurs;
    private int nbValeurs;

    public CalculMoyenne(double[] valeurs) {
        this.valeurs = new double[valeurs.length];
        for (int i = 0; i < valeurs.length; i++) {
            this.valeurs[i] = valeurs[i];
        }
        this.nbValeurs = valeurs.length;
    }

    public void ajout( double valeur) {
        double[] nouveautableau = new double[nbValeurs + 1];

        for (int i = 0; i < nbValeurs; i++) {
            nouveautableau[i] = valeurs[i];
        }

        nouveautableau[nbValeurs] = valeur;

        this.valeurs = nouveautableau;
        this.nbValeurs++;
    }

    public double calcul() throws Exception {
        if (nbValeurs == 0) {
             throw new Exception("Le tableau est vide");
        }

        double somme = 0;
        for (double valeur : valeurs) {
            somme += valeur;
        }

        return somme / nbValeurs;
    }

    @Override
    public String toString() {
        return "CalculMoyenne{" +
                "valeurs=" + Arrays.toString(valeurs) +
                ", nbValeurs=" + nbValeurs +
                '}';
    }
}
