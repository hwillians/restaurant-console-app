package dev;

import dev.dao.PlatDaoFichier;
import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.PlatServiceVersion1;
import dev.service.PlatServiceVersion2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            // Choix du Dao
            PlatDaoMemoire platDaoMemoire = new PlatDaoMemoire();
            // PlatDaoFichier platDaoFichier = new PlatDaoFichier("A_COMPLETER/2020-03-formation-spring/restaurant.txt");

            // Choix du service
            // PlatServiceVersion1 platServiceVersion1 = new PlatServiceVersion1(platDaoFichier);
            PlatServiceVersion2 platServiceVersion2 = new PlatServiceVersion2(platDaoMemoire);

            // Construction du menu avec le service choisi
            Menu menu = new Menu(scanner, platServiceVersion2);

            menu.afficher();
        }
    }
}
