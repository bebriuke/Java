package lt.bit.spring.dao;

import lt.bit.spring.db.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDAO extends JpaRepository<Contact, Integer> {

}
