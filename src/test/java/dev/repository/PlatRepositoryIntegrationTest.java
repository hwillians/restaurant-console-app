package dev.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import dev.config.JdbcTestConfig;
import dev.config.JpaConfig;
import dev.dao.BasePlatDaoBddIntegrationTest;
import dev.dao.PlatDaoJpa;
import dev.entite.Ingredient;
import dev.entite.Plat;

@SpringJUnitConfig(classes = { PlatDaoJpa.class, JdbcTestConfig.class, JpaConfig.class })
@ActiveProfiles({ "jpa" })
public class PlatRepositoryIntegrationTest extends BasePlatDaoBddIntegrationTest {

	@Autowired
	private PlatRepository platRepository;

	@Test
	void testFindAll() {
		List<Plat> plats = platRepository.findAll();
		assertThat(plats).isNotEmpty();
	}

	@Test
	void testFindAllSortAsc() {
		List<Plat> plats = platRepository.findAll(Sort.by("prixEnCentimesEuros").ascending());
		assertThat(plats).isSortedAccordingTo(Comparator.comparing(Plat::getPrixEnCentimesEuros));
	}

	@Test
	void estFindAllSortDesc() {
		List<Plat> plats = platRepository.findAll(Sort.by("prixEnCentimesEuros").descending());
		assertThat(plats).isSortedAccordingTo(Comparator.comparing(Plat::getPrixEnCentimesEuros).reversed());
	}

	@Test
	void testFindAllPageable() {
		Pageable sortedByNomAsc = PageRequest.of(0, 2, Sort.by("nom").ascending());
		List<Plat> plats = platRepository.findAll(sortedByNomAsc).getContent();
		assertThat(plats).extracting(Plat::getNom).contains("Blanquette de veau", "Couscous");
	}

	@Test
	void testFindById() {
		Optional<Plat> p = platRepository.findById(3);
		Plat plat = p.orElseThrow(() -> new RuntimeException("L'id = 4 existe, la requête devrait retourner un plat"));
		assertThat(plat.getNom()).isEqualTo("Couscous");
	}

	@Test
	@Transactional
	void testGetOne() {
		Plat p = platRepository.getOne(3);
		assertThat(p.getNom()).isEqualTo("Couscous");
	}

	@Test
	void testCount() {
		assertThat(platRepository.count()).isEqualTo(6);
	}

	@Test
	void testFindByPrix() {
		assertThat(platRepository.findByPrixEnCentimesEuros(1300)).extracting(Plat::getNom)
				.contains("Magret de canard");
	}

	@Test
	void testAvgPrix() {
		Double moyenne = platRepository.findByAvgPrixSuppA(1000);
		double total = 0;
		int compte = 0;
		List<Plat> plats = platRepository.findAll();
		for (Plat p : plats) {
			if (p.getPrixEnCentimesEuros() > 1000) {
				total += p.getPrixEnCentimesEuros();
				compte++;
			}
		}
		assertThat(moyenne).isEqualTo(total / compte);

	}

	@Test
	void testFindByNomWithIngredients() {
		Optional<Plat> p = platRepository.findByNomWithIngredients("Moules-frites");
		Plat plat = p.orElseThrow(() -> new RuntimeException("Magret de canard existe !!!"));
		assertThat(plat.getIngredients()).extracting(Ingredient::getNom).contains("Moule", "Beurre", "Persil", "Thym",
				"Poivre", "Vin blanc sec");
	}

	@Test
	void testSave() {

		long countBefore = platRepository.count();

		Plat plat = new Plat();
		plat.setNom("pollo");
		plat.setPrixEnCentimesEuros(2500);
		platRepository.save(plat);

		long countAfter = platRepository.count();
		assertThat(countAfter).isEqualTo(countBefore + 1);
		assertThat(platRepository.findAll()).extracting(Plat::getNom).contains(plat.getNom());
		assertThat(platRepository.findAll()).extracting(Plat::getPrixEnCentimesEuros)
				.contains(plat.getPrixEnCentimesEuros());
	}

	@Test
	@Transactional
	void testChangerNom() {
		platRepository.updateNomPlat("Couscous", "Couscous-Merguez");
		List<Plat> listPlat = platRepository.findAll();
		assertThat(listPlat).extracting(Plat::getNom).contains("Couscous-Merguez");
	}
}
