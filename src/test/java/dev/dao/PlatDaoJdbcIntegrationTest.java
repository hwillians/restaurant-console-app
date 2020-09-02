package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import dev.entite.Plat;

public class PlatDaoJdbcIntegrationTest {

	// valide que PlatDaoJdbc::listerPlats ne retourne pas une liste vide.

	@Test
	void listerPlatsNonVideTest() {
		
		List<Plat> resultat;
		
		
	}

	// qui invoque la méthode PlatDaoJdbc::ajouterPlat et vérifie à l’aide du
	// JdbcTemplate qu’un plat est bien inséré.

	@Test
	void ajouterPlatTest() {

	}

}
