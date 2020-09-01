package dev.dao;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.entite.Plat;

@SpringJUnitConfig(classes = PlatDaoFichier.class)
@TestPropertySource("classpath:test.properties")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ANNOTATED)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS )
class PlatDaoFichierTest {

	
	PlatDaoFichier plat;
	
	@Autowired
	public PlatDaoFichierTest(PlatDaoFichier plat) {
		this.plat = plat;
	}

	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD) 
	void ajouterPlatTest() {
		
		plat.ajouterPlat("arroz", 55);

		
		assertThat(this.plat.listerPlats().size()).isEqualTo(1);
		assertThat(this.plat.listerPlats()).extracting(Plat::getNom).containsAnyOf("arroz");
		assertThat(this.plat.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).containsAnyOf(55);
	}

}
