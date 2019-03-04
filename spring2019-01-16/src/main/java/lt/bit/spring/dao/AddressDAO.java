package lt.bit.spring.dao;

import lt.bit.spring.db.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Integer> {

}
