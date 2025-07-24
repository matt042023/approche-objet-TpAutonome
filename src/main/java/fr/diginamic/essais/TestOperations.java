package fr.diginamic.essais;

import fr.diginamic.operations.Operations;

public class TestOperations {
    public static void main(String[] args) throws Exception {
        double a = 10;
        double b = 20;

        System.out.println("si a = " + a + " et  b = " + b);
        System.out.println( "addition : a + b = " + new Operations().calcule( a, b, '+' ));
        System.out.println("Soustraction : a - b = " + new Operations().calcule( a, b, '-' ));
        System.out.println("Multiplication : a * b = " + new Operations().calcule( a, b, '*' ));
        System.out.println("Division : a / b = " + new Operations().calcule( a, b, '/' ));

    }
}
