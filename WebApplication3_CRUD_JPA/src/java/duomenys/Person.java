package duomenys;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jurate Valatkevicien
 */

@Entity
@Table(name="persons")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="birth_date")
    private Date birthDate;
    //jeigu sutampa, @Column nereikia
    private BigDecimal salary;
    @OneToMany(mappedBy = "p")
    private List<Address> addresses;
    @OneToMany
    private List<Contacts> contacts; //???
    //kintamasis, kurio nėra duomenų bazėje
   // @Transient
   // String test;

    public Person() {
        addresses = new ArrayList<>();
        //contacts = new ArrayList<>();
    }

    
    public Person(String firstName, String lastName, Date birthDate, BigDecimal salary) {
        //id = 17; //!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
        addresses = new ArrayList<>();
        //contacts = new ArrayList<>();
        
    }

    public Integer getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }
    
    

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", salary=" + salary  + '}';
    }
    
    public static Address getAddressById(Integer id, List <Address> list) {
        if (id == null) {
            return null;
        }
        for (Address p : list) {
            if (id.equals(p.getId())) {
                return p;
            }
        }
        return null;
    }
    
    
    public static Contacts getContactById(Integer id, List <Contacts> list) {
        if (id == null) {
            return null;
        }
        for (Contacts p : list) {
            if (id.equals(p.getId())) {
                return p;
            }
        }
        return null;
    }
    
    
}
