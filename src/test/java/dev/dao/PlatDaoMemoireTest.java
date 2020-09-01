package dev.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import dev.entite.Plat;

public class PlatDaoMemoireTest {

	private PlatDaoMemoire platDaoMemoire;

	@Before
	public void setUp() {
		this.platDaoMemoire = new PlatDaoMemoire();
	}

	@Test
	public void listerPlatsVideALInitialisation() { // TODO

		List<Plat> resultat = platDaoMemoire.listerPlats();
		assertThat(resultat.size()).isEqualTo(0);
	}

	@Test
	public void ajouterPlatCasPassants() { // TODO

		platDaoMemoire.ajouterPlat("arroz", 55);
		List<Plat> resultat = platDaoMemoire.listerPlats();
		assertThat(resultat.get(0).getNom()).isEqualTo("arroz");
		assertThat(resultat.get(0).getPrixEnCentimesEuros()).isEqualTo(55);

	}

}
