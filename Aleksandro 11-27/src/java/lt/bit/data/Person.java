package lt.bit.data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Person {

    private static int nextId = 0;

    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;  //1999-02-03
    private BigDecimal salary;

    public Person() {
        this.id = ++nextId;
    }

    public Person(String firstName, String lastName, Date birthDate, BigDecimal salary) {
        this.id = ++nextId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public Date getBirthDate() {
        
        return birthDate; 
    }
    public void setBirthDate(Date birthDate)  {
        this.birthDate = birthDate;
    }
    
    public BigDecimal getSalary() {
        return salary;
    }    

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    
    

    public void setId(Integer id) {
        this.id = id;
    }

    public void createId() {
        this.id = ++nextId;
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


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", salary=" + salary + '}';
    }


}
