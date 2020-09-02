/**
 * 
 */
package dev.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource dataSource(
			@Value("${bdd.driver}") String driver,
			@Value("${bdd.user}") String utilisateur,
			@Value("${bdd.pass}") String motDePasse,
			@Value("${bdd.url}") String url
			) {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(utilisateur);
		ds.setPassword(motDePasse);
		return ds;
	}

}
