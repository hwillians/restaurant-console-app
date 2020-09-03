package dev.dao;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.config.JpaConfig;

@SpringJUnitConfig(classes = { PlatDaoJpa.class, JdbcTestConfig.class, JpaConfig.class })
@ActiveProfiles({ "jpa" })
class PlatDaoJpaTest extends BasePlatDaoBddIntegrationTest {

}
