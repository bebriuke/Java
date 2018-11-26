/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duomenys;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jurate Valatkevicien
 */
public class DB {
    private static List <Person> list = new ArrayList<>();
    
    static{
        Person p = new Person();
        p.setFirstName("PirmasVardas");
        p.setLastName("PirmaPavardė");
        list.add(p);
        p = new Person();
        p.setFirstName("AntrasVardas");
        p.setLastName("AntraPavardė");
        list.add(p);
    }
    
    public static List <Person> getAll(){
        return list;
    }
    
    public static Person add(Person p){
        if (p ==null){
            throw new RuntimeException("No person to add");
        }
        if(list.contains(p)){
            throw new RuntimeException("Person exists");
        }
        if(p.getId() == null){
            p.creatNewId();
        }
        list.add(p);
        return p;
    }
    
    public static Person getById(Integer id){
        if(id == null) return null;
        for(Person p: list){
            if(id.equals(p.getId())){
                return p;
            }
        }
        return null;
    }
    
    public static Person delete (Integer id){
        Person p = getById(id);
        if (p != null){
            list.remove(p);
        }
        return p;
    }
    
    public static Person update(Person p){
        if(p == null) return null;
        Person realP = setById(p.getId());
        if(realP != null){
            realP.setFirstName(p.getFirstName());
            realP.setLastName(p.getLastName());
        }
        return realP;
    }

    private static Person setById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
