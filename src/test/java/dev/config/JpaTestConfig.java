package dev.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@Import(DataSourceH2TestConfig.class)
public class JpaTestConfig {
	
	// Configuration de l'EntityManagerFactory
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
			HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
			// vendorAdapter.setGenerateDdl(true);
			vendorAdapter.setShowSql(true);
			// activer les logs SQL
			LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
			emf.setJpaVendorAdapter(vendorAdapter);
			emf.setPackagesToScan("dev.entite");
			emf.setDataSource(dataSource);
			emf.afterPropertiesSet();
			return emf;
		}

		// Configuration du gestionnaire de transaction pour JPA
		@Bean
		public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
			JpaTransactionManager transactionManager = new JpaTransactionManager();
			transactionManager.setEntityManagerFactory(emf);
			return transactionManager;
		}

	

}
