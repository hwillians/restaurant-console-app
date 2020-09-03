package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;

import dev.entite.Plat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class BasePlatDaoBddIntegrationTest {

	@Autowired
	private IPlatDao dao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void listerPlatsNonVideTest() {
		List<Plat> plats = dao.listerPlats();
		assertThat(plats).isNotEmpty();
	}

	@Test
	public void ajouterPlatTest() {

		dao.ajouterPlat("caraotas", 5001);

		Integer prix = jdbcTemplate.queryForObject("select prix from plat where nom='caraotas'", Integer.class);

		assertThat(prix).isEqualTo(5001);
	}
}
