package fr.diginamic.combat;

import java.util.Random;

public class PotionSoin implements Potion{

    @Override
    public String getNom() {
        return "Potion de soin";
    }

    @Override
    public void appliquer(Personnage personnage) {
        int soin = 5 + new Random().nextInt(6); // 5 à 10
        personnage.ajouterSante(soin);
        System.out.println("🧪 Vous récupérez " + soin + " points de santé !");
    }
}
