package lt.bit.projektas;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="addresses")
public class Address implements Serializable {

    

   @Id @GeneratedValue(strategy=GenerationType.IDENTITY )               private Integer id;
   @Column (name="address")                                             private String address;
                                                                        private String city;
   @Column (name="postal_code")                                         private String postalCode;
   @ManyToOne   @JoinColumn(name = "person_id")                         private Person person;
                                                        
    public Address() {
        
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address(String address, String city, String postalCode) {
       
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Address(Integer id, String address, String city, String postalCode) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void createId() {
      
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + '}';
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
        final Address other = (Address) obj;
        return Objects.equals(this.id, other.id);
    }

}
