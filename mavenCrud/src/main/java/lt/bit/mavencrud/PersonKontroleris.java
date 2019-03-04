/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.mavencrud;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author macbookair
 */
@Controller 
@RequestMapping("/persons")
public class PersonKontroleris {
   
    @GetMapping
    public ModelAndView index() {
        
        ModelAndView mav = new ModelAndView("persons");
        
        EntityManager em = EMF.getEntityManager();
        Query q = em.createQuery("SELECT p FROM Person p");
        List <Person> l = q.getResultList();
        
        mav.addObject("persons", l);
        
        EMF.returnEntityManager(em);
        return mav;
    }
   
    @GetMapping("delete")
    public String deletePerson(@RequestParam("id") Integer id) throws Exception {
        EntityManager em = EMF.getEntityManager();
        try {
            EntityTransaction tx = EMF.getTransaction(em);

            em.remove(em.find(Person.class, id));

            EMF.commitTransaction(tx);
        } catch (Exception ex) {
            throw ex;
        } finally {
            EMF.returnEntityManager(em);
         return "redirect:/persons";
      
        }
    }
    
    @GetMapping("edit")
    public ModelAndView editPerson(@RequestParam(name = "id", required = false) Integer id) throws Exception {
        
        ModelAndView mav = new ModelAndView("edit");
        
        EntityManager em = EMF.getEntityManager();
        if( id != null){
        mav.addObject("persons", em.find(Person.class, id));
        }
       
        EMF.returnEntityManager(em);
         return mav;
      
        }
    
    @PostMapping("edit")
    public String savePerson(@RequestParam("id") Integer id,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("birthDate") String birthDateString,
                             @RequestParam("salary") BigDecimal salary) throws Exception {

        EntityManager em = EMF.getEntityManager();
        Person p = null;
        ModelAndView mav = new ModelAndView("edit");
        
        
        
        Date birthDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        birthDate = sdf.parse(birthDateString);
    
        try {
            EntityTransaction tx = EMF.getTransaction(em);
            if (id != null) {
                
                p = em.find(Person.class, id);
                
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setBirthDate(birthDate);
                p.setSalary(salary);

               // em.merge(p);
                
            } else {
                
                p = new Person();
                
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setBirthDate(birthDate);
                p.setSalary(salary);

//                em.persist(p);

            }
            mav.addObject("person", p);
            EMF.commitTransaction(tx);
        } catch (Exception ex) {
            throw ex;
        } finally {
            EMF.returnEntityManager(em);
            
        }
        return "redirect:/persons";
        }
    
}
    

