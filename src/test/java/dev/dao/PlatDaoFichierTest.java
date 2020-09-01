package dev.dao;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.entite.Plat;


@SpringJUnitConfig(PlatDaoFichier.class)
@TestPropertySource("classpath:test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PlatDaoFichierTest {

	@Autowired
	private PlatDaoFichier plat;

	@Test
	void ajouterPlatTest() {
		
		plat.ajouterPlat("arroz", 55);

		
		assertThat(this.plat.listerPlats().size()).isEqualTo(1);
		assertThat(this.plat.listerPlats()).extracting(Plat::getNom).containsAnyOf("arroz");
		assertThat(this.plat.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).containsAnyOf(55);
	}
	
	@Test
	void ajouterPlatEncoreTest() {
		
		plat.ajouterPlat("arroz", 55);

		
		assertThat(this.plat.listerPlats().size()).isEqualTo(1);
		assertThat(this.plat.listerPlats()).extracting(Plat::getNom).containsAnyOf("arroz");
		assertThat(this.plat.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).containsAnyOf(55);
	}

}
