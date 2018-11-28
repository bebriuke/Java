package lt.bit.db;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lt.bit.data.Person;

public class DB {

    private static final List<Person> list = new ArrayList<>();
    
    
    static {
        Person p;
        try {
            DateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
            
            p = new Person("PirmasVardas", "PirmaPavarde", format.parse("2006-10-08"), new BigDecimal("1000"));
            list.add(p);
            p = new Person("AntrasVardas", "AntraPavarde", format.parse("2004-03-12"), new BigDecimal("2000"));
            list.add(p);
        } catch (ParseException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static List<Person> getAll() {
        return list;
    }

    public static Person getById(Integer id) {
        if (id == null) {
            return null;
        }
        for (Person p : list) {
            if (id.equals(p.getId())) {
                return p;
            }
        }
        return null;
    }

    public static Person add(Person p) {
        if (!list.contains(p)) {
            p.createId();
            list.add(p);
            return p;
        }
        return null;
    }

    public static Person update(Person p) {
        if (p == null) {
            return null;
        }
        Person currentPerson = getById(p.getId());
        if (currentPerson != null) {
            currentPerson.setFirstName(p.getFirstName());
            currentPerson.setLastName(p.getLastName());
        }
        return currentPerson;
    }

    public static Person delete(Integer id) {
        Person p = getById(id);
        if (p != null) {
            list.remove(p);
        }
        return p;
    }

}
