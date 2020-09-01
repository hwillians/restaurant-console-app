package dev;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.ihm.Menu;

/**
 * @author helvin
 *
 */
public class AppSpringXML {

	
	public static void main(String[] args) {

		// Création du contexte Spring
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"application-config-fichier.xml")) {

			// récupération du bean Menu
			Menu menu = context.getBean(Menu.class);
			menu.afficher();

		} // fermeture du contexte spring => context.cole()

	}

}
