package dev.ihm.options;

import dev.exception.PlatException;
import dev.service.IPlatService;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class OptionAjouterPlat implements IOptionMenu {
    private Scanner scanner;

    private IPlatService service;

    public OptionAjouterPlat(Scanner scanner, IPlatService service) {
        this.scanner = scanner;
        this.service = service;
    }

    @Override
    public String getTitre() {
        return "Ajouter un plat";
    }

    @Override
    public void executer() {

        boolean saisieKO = true;

        while (saisieKO) {

            System.out.println("Saisissez le nom du plat (sans espaces) :");
            String nomPlat = this.scanner.next();

            System.out.println("Saisissez le prix en centimes d'euros :");
            Integer prix = this.scanner.nextInt();

            try {

                this.service.ajouterPlat(nomPlat, prix);
                saisieKO = false;
            } catch (PlatException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
