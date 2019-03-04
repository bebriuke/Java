/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jurate Valatkevicien
 */
@Controller
@RequestMapping("/") //  /skaiciuok
public class Kontroleris {
    @GetMapping
    public String index (){
        return "index";
    }
    
    @GetMapping(path = "sudetis/{a}/{b}")  //"{a}+{b}"
    public ModelAndView sudetis (@PathVariable("a") int a, @PathVariable("b") int b){
        ModelAndView mv = new ModelAndView("sudetis");
        mv.addObject("a", a);
        mv.addObject("b", b);
        return mv;
    }
    
    
    @GetMapping(path = "atimtis/{a}/{b}")//"{a}-{b}"
    public ModelAndView atimtis (@PathVariable("a") int a, @PathVariable("b") int b){
        ModelAndView mv = new ModelAndView("atimtis");
        mv.addObject("a", a);
        mv.addObject("b", b);
        return mv;
    }
    
    //metodas gali gražinti arba String arba ModelAndView objektą.
    
    
    
}
