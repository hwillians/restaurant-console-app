package dev.ihm.options;

import org.springframework.stereotype.Controller;

import dev.service.IPlatService;

@Controller
public class OptionListerPlats implements IOptionMenu {

    private IPlatService service;

    public OptionListerPlats(IPlatService service) {
        this.service = service;
    }

    @Override
    public String getTitre() {
        return "Lister plats";
    }

    @Override
    public void executer() {

        this.service.listerPlats().forEach(plat -> System.out.println(plat.getNom() + " (" + (plat.getPrixEnCentimesEuros() / 100) + " €)"));

    }
    
    @Override
    public int getPoids() {
        return 101;
    }

}
