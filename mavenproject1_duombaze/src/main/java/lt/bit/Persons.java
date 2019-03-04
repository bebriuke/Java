/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Jurate Valatkevicien
 */
@Controller
@RequestMapping("/persons")
public class Persons {
    @GetMapping
    public String index (){
        return "index";
    }
    
    @PostMapping
    public String savePerson(@RequestParam("id") Integer id, @RequestParam("firstName") String firstName){
        //čia reikia išsaugoti personą
        return "redirect:/persons";
    }
    
    
    
}
