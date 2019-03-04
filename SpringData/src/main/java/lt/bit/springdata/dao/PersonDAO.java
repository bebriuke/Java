/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.springdata.dao;

import lt.bit.springdata.db.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jurate Valatkevicien
 */
public interface PersonDAO extends JpaRepository<Persons, Integer>{
    
}
