package lt.bit.spring.dao;

import lt.bit.spring.db.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person, Integer> {

}
