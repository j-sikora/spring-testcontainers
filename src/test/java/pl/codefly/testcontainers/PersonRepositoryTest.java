package pl.codefly.testcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.codefly.testcontainers.config.AbstractContainerTest;
import pl.codefly.testcontainers.config.TestConfig;
import pl.codefly.testcontainers.entities.Person;
import pl.codefly.testcontainers.repositories.PersonRepository;

import static org.junit.Assert.*;

@SpringBootTest
@Testcontainers
@ContextConfiguration(classes = TestConfig.class)
public class PersonRepositoryTest extends AbstractContainerTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @Transactional
    public void testPersonInsert() {
        Person person = Person.builder()
                .firstname("Janusz")
                .lastname("Oszczędny")
                .state("single")
                .build();
        assertNotNull(person);
        assertNull(person.getId());
        person = personRepository.save(person);
        assertNotNull(person.getId());
        assertTrue(person.getId() > 0);

        System.out.println("person:" + person);
    }

}