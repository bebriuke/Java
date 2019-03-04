package lt.bit.spring.dao;

import lt.bit.spring.db.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nikanoras
 */
public interface RolesDAO extends JpaRepository<Roles, Integer> {

}
