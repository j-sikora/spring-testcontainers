package pl.codefly.testcontainers.config;

import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

import static pl.codefly.testcontainers.config.AbstractContainerTest.POSTGRES_SQL_CONTAINER;

@TestConfiguration
public class TestConfig {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(POSTGRES_SQL_CONTAINER.getJdbcUrl());
        dataSource.setUsername(POSTGRES_SQL_CONTAINER.getUsername());
        dataSource.setPassword(POSTGRES_SQL_CONTAINER.getPassword());
        dataSource.setDriverClassName(POSTGRES_SQL_CONTAINER.getDriverClassName());
        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.yaml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }


}
