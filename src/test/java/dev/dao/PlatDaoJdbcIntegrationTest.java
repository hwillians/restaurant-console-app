package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.entite.Plat;

@SpringJUnitConfig(classes = { PlatDaoJdbc.class, JdbcTestConfig.class })
@ActiveProfiles({ "jdbc" })
public class PlatDaoJdbcIntegrationTest {

	@Autowired
	private PlatDaoJdbc plat;

	@Autowired
	private JdbcTemplate template;

	@Test
	void listerPlatsNonVideTest() {
		List<Plat> plats = plat.listerPlats();
		assertThat(plats).isNotEmpty();
	}

	@Test
	void ajouterPlatTest() {

		plat.ajouterPlat("caraotas", 5001);
		Integer prix = template.queryForObject("select prix from plat where nom='caraotas'", Integer.class);
		assertThat(prix).isEqualTo(5001);
	}

}
