package fr.diginamic.operations;

public class Operations {
    public double calcule( double a, double b, char op) throws Exception{
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: throw new Exception("Opérateur non reconnu : " + op);
        }

    }
}
