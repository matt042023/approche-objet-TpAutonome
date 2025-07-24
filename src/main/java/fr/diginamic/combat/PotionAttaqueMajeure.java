package fr.diginamic.combat;

public class PotionAttaqueMajeure implements Potion {

    @Override
    public String getNom() {
        return "Potion d'attaque majeure (+5 attaque pendant 2 combats)";
    }

    @Override
    public void appliquer(Personnage personnage) {
        personnage.setBonusAttaque(5);
        personnage.setDureeBonus(2);
        System.out.println("🔥 Vous bénéficiez d'un bonus d'attaque de +5 pour les 2 prochains combats !");
    }
}
