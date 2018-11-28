package lt.bit.db;

import java.util.ArrayList;
import java.util.List;
import lt.bit.data.Person;

public class DB {

    private static final List<Person> list = new ArrayList<>();

    static {
        Person p = new Person("PirmasVardas", "PirmaPavarde");
        list.add(p);
        p = new Person("AntrasVardas", "AntraPavarde");
        list.add(p);
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
