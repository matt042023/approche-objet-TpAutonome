package fr.diginamic.combat;

import java.util.Random;

public class PotionRobustesse implements Potion {
    @Override
    public String getNom() {
        return "Potion de Robustesse (+5-10 PV max)";
    }

    @Override
    public void appliquer(Personnage personnage) {
        Random rand = new Random();
        int bonus = 5 + rand.nextInt(6); // 5 à 10
        personnage.ajouterSanteMax(bonus);
        System.out.println("✨ Vous gagnez " + bonus + " points de santé maximum !");
    }
}