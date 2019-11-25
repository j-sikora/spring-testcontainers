package pl.codefly.testcontainers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.codefly.testcontainers.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
