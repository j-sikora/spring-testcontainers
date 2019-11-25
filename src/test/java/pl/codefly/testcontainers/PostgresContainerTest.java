package pl.codefly.testcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.codefly.testcontainers.config.AbstractContainerTest;
import pl.codefly.testcontainers.config.TestConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@Testcontainers
@ContextConfiguration(classes = TestConfig.class)
public class PostgresContainerTest extends AbstractContainerTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void checkCurrentUser() {
        String currentUser = (String) entityManager.createNativeQuery("SELECT current_user").getSingleResult();
        System.out.println("current_user:" + currentUser);
        assertEquals(POSTGRES_SQL_CONTAINER.getUsername(), currentUser);
    }
}
