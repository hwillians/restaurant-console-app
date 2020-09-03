package dev.repository;

import static org.assertj.core.api.Assertions.assertThat;

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
		assertThat(plats.get(0).getPrixEnCentimesEuros()).isLessThan(plats.get(1).getPrixEnCentimesEuros());
	}

	@Test
	void estFindAllSortDesc() {
		List<Plat> plats = platRepository.findAll(Sort.by("prixEnCentimesEuros").descending());
		assertThat(plats.get(0).getPrixEnCentimesEuros()).isGreaterThan(plats.get(1).getPrixEnCentimesEuros());
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
		assertThat(p.get().getNom()).isEqualTo("Couscous");

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

		List<Plat> plats = platRepository.findByPrixEnCentimesEuros(1300);

		assertThat(platRepository.findByPrixEnCentimesEuros(1300)).extracting(Plat::getNom)
				.contains("Magret de canard");

	}

	@Test
	void testAvgPrix() {

	}

}
