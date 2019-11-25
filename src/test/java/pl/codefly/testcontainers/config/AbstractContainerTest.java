package pl.codefly.testcontainers.config;

import org.testcontainers.containers.PostgreSQLContainer;

public class AbstractContainerTest {
    public static final PostgreSQLContainer POSTGRES_SQL_CONTAINER;

    static {
        POSTGRES_SQL_CONTAINER = new PostgreSQLContainer("postgres")
                .withDatabaseName("postgres")
                .withUsername("integrationUser")
                .withPassword("testPass");
        POSTGRES_SQL_CONTAINER.start();
    }
}
