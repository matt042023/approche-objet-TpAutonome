package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

public class TestMoyenne {
    public static void main(String[] args) throws Exception {

        CalculMoyenne moyenne1 = new CalculMoyenne(new double[]{61,25,38,94,55});
        System.out.println(moyenne1);
        System.out.println(moyenne1.calcul());


        moyenne1.ajout(6);
        System.out.println(moyenne1);
        System.out.println(moyenne1.calcul());



        CalculMoyenne moyenne2 = new CalculMoyenne(new double[0]);
        System.out.println(moyenne2);
        moyenne2.ajout(5);
        moyenne2.ajout(56);
        moyenne2.ajout(548);
        moyenne2.ajout(68);
        moyenne2.ajout(756);
        moyenne2.ajout(44);
        System.out.println(moyenne2);
        System.out.println(moyenne2.calcul());


    }
}
