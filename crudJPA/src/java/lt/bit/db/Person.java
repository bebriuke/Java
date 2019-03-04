package lt.bit.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persons")
public class Person {
    
    @OneToMany(mappedBy = "per")
    private List<Address> adrList;
    
    @OneToMany(mappedBy = "pers")
    private List<Contacts> conList;
            
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private BigDecimal salary;
    
// kintamojo anotacija kurios nera duombazej
//    @Transient
//    private String kurioNera

    public List<Contacts> getConList() {
        return conList;
    }

    public void setConList(List<Contacts> kontaktai) {
        this.conList = kontaktai;
    }

    
     public List<Address> getAdresai() {
        return adrList;
    }

    public void setAdresai(List<Address> adresai) {
        this.adrList = adresai;
    }
    
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", salary=" + salary + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
