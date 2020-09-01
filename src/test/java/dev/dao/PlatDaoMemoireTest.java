package dev.dao;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import dev.entite.Plat;

public class PlatDaoMemoireTest {

	private PlatDaoMemoire platDaoMemoire;

	@BeforeEach
	public void setUp() {
		this.platDaoMemoire = new PlatDaoMemoire();
	}

	@Test
	public void listerPlatsVideALInitialisation() { // TODO

		List<Plat> resultat = platDaoMemoire.listerPlats();
		assertThat(resultat).isEmpty();
	}

	@Test
	public void ajouterPlatCasPassants() { // TODO
		
		int nbmDePlatAvant = platDaoMemoire.listerPlats().size();

		platDaoMemoire.ajouterPlat("arroz", 55);
		List<Plat> resultatApres = platDaoMemoire.listerPlats();
		
		
		assertThat(resultatApres.size()).isEqualTo(nbmDePlatAvant+1);
		assertThat(resultatApres).extracting(Plat::getNom).containsAnyOf("arroz");
		assertThat(resultatApres).extracting(Plat::getPrixEnCentimesEuros).containsAnyOf(55);

	}

}
