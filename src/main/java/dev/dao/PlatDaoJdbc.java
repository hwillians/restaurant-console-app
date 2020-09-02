/**
 * 
 */
package dev.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.List;

import dev.entite.Plat;

/**
 * @author helvin
 *
 */
@Repository
@Profile("jdbc")
public class PlatDaoJdbc implements IPlatDao {

	private JdbcTemplate jdbcTemplate;

	public PlatDaoJdbc(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Plat> listerPlats() {
		return this.jdbcTemplate.query("select * from plat", new VoyageRowMapper());
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		this.jdbcTemplate.update("Insert into plat (nom,prix) values(?,?)", nomPlat, prixPlat);

	}

}
