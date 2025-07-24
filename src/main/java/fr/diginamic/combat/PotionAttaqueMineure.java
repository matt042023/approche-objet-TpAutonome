package fr.diginamic.combat;

public class PotionAttaqueMineure implements Potion {

    @Override
    public String getNom() {
        return "Potion d'attaque mineure (+3 attaque pendant 1 combat)";
    }

    @Override
    public void appliquer(Personnage personnage) {
        personnage.setBonusAttaque(3);
        personnage.setDureeBonus(1);
        System.out.println("💪 Vous bénéficiez d'un bonus d'attaque de +3 pour le prochain combat !");
    }
}
