package dev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import dev.config.AppConfig;
import dev.ihm.Menu;

/**
 * @author helvin
 * 
 */
public class AppSpringJava {

	public static void main(String[] args) {

		// Création du contexte Spring à partir d'une configuration Java
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			// Recueration du contexte Spring à partir d'une configuration Java

			Menu menu = context.getBean(Menu.class);

			menu.afficher();
		}  catch (DataAccessException e) {
            System.out.println("Problème d'accès à la base de données");
        }


	}

}
