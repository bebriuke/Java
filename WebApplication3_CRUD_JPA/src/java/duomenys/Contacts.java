package duomenys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(name="person_id")
//    private Integer personId;
    //nereikia, sutampa pavadinimai
    private String type;
    //nereikia, sutampa pavadinimai
    @Column(name="contact")
    private String addres;
    @ManyToOne
    @JoinColumn(name = "Person_id")
    private Person p;
    
     public Contacts() {
    }


    public Contacts(String type, String addres) {
        this.type = type;
        this.addres = addres;
    }

    public Integer getId() {
        return id;
    }

    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
    
    
}
