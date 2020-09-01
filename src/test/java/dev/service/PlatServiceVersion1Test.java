package dev.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import dev.dao.IPlatDao;
import dev.exception.PlatException;

class PlatServiceVersion1Test {

	private PlatServiceVersion1 service;
	private IPlatDao dao;

	@BeforeEach
	public void setUp() {
		dao = mock(IPlatDao.class);
		service = new PlatServiceVersion1(dao);
	}

	@Test
	void ajouterPlatNomInvalideTest() {
		PlatException exception = assertThrows(PlatException.class, () -> service.ajouterPlat("riz", 501));
		assertEquals("un plat doit avoir un nom de plus de 3 caractères", exception.getMessage());

	}

	@Test
	void ajouterPlatPrixInvalideTest() {
		PlatException exception = assertThrows(PlatException.class, () -> service.ajouterPlat("rizotto", 500));
		assertEquals("le prix d'un plat doit être supérieur à 5 €", exception.getMessage());
	}

	@Test
	void ajouterPlatValideTest() throws PlatException {
		service.ajouterPlat("rizotto", 501);
		verify(dao).ajouterPlat("rizotto", 501);
	}

}
