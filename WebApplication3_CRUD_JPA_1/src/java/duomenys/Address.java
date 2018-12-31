package duomenys;

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
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(name="person_id")
    //private Integer personId;
    //nereikia, sutampa pavadinimai
    private String address;
    //nereikia, sutampa pavadinimai
    private String city;
    @Column(name="postal_code")
    private String postalCode;
    @ManyToOne
    @JoinColumn(name = "Person_id")
    private Person p;

    
    
    
    public Address() {
    }

    public Address(String address, String city, String postalCode) {
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }
    

    public Integer getId() {
        return id;
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
    
    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
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
