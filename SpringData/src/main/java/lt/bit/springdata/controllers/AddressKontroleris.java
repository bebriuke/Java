/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.springdata.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import lt.bit.springdata.dao.AddressDAO;
import lt.bit.springdata.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author macbookair
 */
@Controller
@RequestMapping("/address")
public class AddressKontroleris {
    @Autowired
    private PersonDAO PersonDAO;
    @Autowired
    private AddressDAO AddressesDAO;
    
    @GetMapping
    public ModelAndView addressIndex(@RequestParam("id") Integer id) {
        
        ModelAndView mav = new ModelAndView("address");
        
        
     
       try{ 
        
        Person p = null;
            if( id != null){
                 p = em.find(Person.class, id);
            } 
            if (p==null){
                p=new Person ();
            }
        Query q = em.createQuery("SELECT a FROM Address a");
        List <Address> al = q.getResultList();
        
        mav.addObject("address", al);
        EMF.commitTransaction(tx);
       } catch (Exception ex) {
            throw ex;
        } finally {
        EMF.returnEntityManager(em);
        return mav;
    }
  }  
}
