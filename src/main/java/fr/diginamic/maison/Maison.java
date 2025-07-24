package fr.diginamic.maison;

import java.util.ArrayList;

public class Maison {
    private ArrayList<Piece> pieces = new ArrayList<>();

    public void ajouterPiece(Piece piece) {
        if (piece == null) {
            System.out.println("Erreur : la pièce est null");
            return;
        } else if (piece.getEtage() < 0) {
            System.out.println("Erreur : étage négatif interdit");
            return;
        } else if (piece.getSuperficie() < 0) {
            System.out.println("Erreur : superficie négative interdite");
            return;
        }
        pieces.add(piece);
    }

    public double superficieTotale() {
        double total = 0;
        for (Piece piece : pieces) {
            total += piece.getSuperficie();
        }
        return total;
    }

    public double superficieEtage(int etage) {
        double total = 0;
        for (Piece piece : pieces) {
            if (piece.getEtage() == etage) {
                total += piece.getSuperficie();
            }
        }
        return total;
    }

    public double superficieType(Class<? extends Piece> type) {
        double total = 0;
        for (Piece piece : pieces) {
            if (piece.getClass().equals(type)) {
                total += piece.getSuperficie();
            }
        }
        return total;
    }

    public int nombrePiecesType(Class<? extends Piece> type) {
        int count = 0;
        for (Piece piece : pieces) {
            if (piece.getClass().equals(type)) {
                count++;
            }
        }
        return count;
    }
}
