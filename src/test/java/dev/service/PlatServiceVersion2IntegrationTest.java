package dev.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.dao.PlatDaoMemoire;
import dev.entite.Plat;
import dev.exception.PlatException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PlatDaoMemoire.class, PlatServiceVersion2.class })
@ActiveProfiles({ "memoire", "service2" })
class PlatServiceVersion2IntegrationTest {

	@Autowired
	private PlatServiceVersion2 service;

	@Test
	void ajouterPlatValideTest() {
		service.ajouterPlat("rizotto", 1001);

		assertThat(service.listerPlats()).extracting(Plat::getNom).containsAnyOf("rizotto");
		assertThat(service.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).containsAnyOf(1001);

	}

	@Test
	void ajouterPlatPrixInvalide() {
		PlatException exception = assertThrows(PlatException.class, () -> service.ajouterPlat("rizotto", 1000));
		assertEquals("le prix d'un plat doit être supérieur à 10 €", exception.getMessage());

	}

}
