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
		assertThrows(PlatException.class, () -> service.ajouterPlat("riz", 501));
	}

	@Test
	void ajouterPlatPrixInvalideTest() {
		assertThrows(PlatException.class, () -> service.ajouterPlat("rizotto", 500));
	}

	@Test
	void ajouterPlatValideTest() throws PlatException {
		service.ajouterPlat("rizotto", 501);
		verify(dao).ajouterPlat("rizotto", 501);
	}

}
