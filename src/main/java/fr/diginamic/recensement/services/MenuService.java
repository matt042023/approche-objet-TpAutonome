package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;

import java.util.Scanner;

/**
 * Interface commune à tous les services du menu de l’application.
 */
public abstract class MenuService {
    /**
     * Méthode appelée pour exécuter l’action liée au service.
     * @param recensement Objet contenant toutes les données
     * @param scanner Scanner pour lire les saisies utilisateur
     */
    public abstract void traiter(Recensement recensement, Scanner scanner);
}
