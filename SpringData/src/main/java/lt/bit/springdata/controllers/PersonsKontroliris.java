/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.springdata.controllers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.transaction.Transactional;
import lt.bit.springdata.dao.PersonDAO;
import lt.bit.springdata.db.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jurate Valatkevicien
 */

@Controller
@RequestMapping("/persons")
public class PersonsKontroliris {
    @Autowired
    private PersonDAO PersonDAO;
    
    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("persons");
        mav.addObject("persons", PersonDAO.findAll());
        return mav;
    }
    
    @GetMapping("delete")
    @Transactional
    public String deletePerson(@RequestParam("id") Integer id) throws Exception{
        PersonDAO.deleteById(id);
        return "redirect:/persons";
    }
    
    @GetMapping("edit")
    @Transactional
    public String editPerson(@RequestParam("id") Integer id) throws Exception{
        ModelAndView mav = new ModelAndView("edit");
        if(id != null){}
        return "redirect:/persons";
    }
    
    @PostMapping("save")
    public String savePerson(@RequestParam("id") Integer id,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("birthDate") String birthDateString,
                             @RequestParam("salary") BigDecimal salary) throws Exception {

        Persons p = null;
        ModelAndView mav = new ModelAndView("edit");
        
        
        
        Date birthDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        birthDate = sdf.parse(birthDateString);
    
        try {
            if (id != null) {
                p = PersonDAO.findById(id)
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
