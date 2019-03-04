/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.mavencrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author macbookair
 */
@Controller
@RequestMapping("/sk")
public class Kontroleris {

    @GetMapping
    public String index() {
        return "index";
    }
    
    @GetMapping(path = "{a}+{b}")
    public ModelAndView sudetis(@PathVariable("a") int a, @PathVariable("b") int b){
        ModelAndView mav = new ModelAndView("sudetis");
        mav.addObject("a", a);
        mav.addObject("b", b);
        return mav;
    }
    
    @GetMapping(path = "{a}-{b}")
    public ModelAndView atimtis(@PathVariable("a") int a, @PathVariable("b") int b){
        ModelAndView mav = new ModelAndView("atimtis");
        mav.addObject("a", a);
        mav.addObject("b", b);
        return mav;
    }
    
   
}
