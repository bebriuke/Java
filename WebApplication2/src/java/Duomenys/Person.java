/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duomenys;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private static int nextId = 0;
    
    public Person (){
        this.id = nextId++;
    }

    @Override
    public String toString() {
        return "|  " + id + "  |  " + firstName + "  |  " + lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static int getNextId() {
        return nextId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void setNextId(int nextId) {
        Person.nextId = nextId;
    }
    
    public boolean equals(Object o){
        if (o == null) return false;
        if (!o.getClass().equals(this.getClass())) return false;
        Integer old = ((Person)o).getId();
        if (old == null || this.id == null) return false;
        return old.equals(this.id);
    }

    void creatNewId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
