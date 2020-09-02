package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import dev.config.JpaTestConfig;
import dev.entite.Plat;

@SpringJUnitConfig(classes = { PlatDaoJpa.class, JpaTestConfig.class })
@ActiveProfiles({ "jpa" })
class PlatDaoJpaTest {

	@Autowired
	private PlatDaoJpa plat;

	@Test
	void listerPlatsNonVideTest() {
		List<Plat> plats = plat.listerPlats();
		assertThat(plats).isNotEmpty();
	}

	@Test
	@Transactional
	void ajouterPlatTest() {
		plat.ajouterPlat("caraotas", 5001);
		assertThat(plat.listerPlats()).extracting(Plat::getNom).contains("caraotas");
		assertThat(plat.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).contains(5001);

	}

}
