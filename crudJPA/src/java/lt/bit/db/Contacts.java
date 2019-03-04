package lt.bit.db;

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
@Table(name = "contacts")
public class Contacts {

    @ManyToOne
    @JoinColumn(name = "persons_id")
    private Person pers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "contact")
    private String contact;

       public Contacts () {
    }

    public Contacts(String type, String contact) {
        this.type = type;
        this.contact = contact;
        
    }

    public Contacts (Integer id, String type, String contacts) {
        this.id = id;
        this.type = type;
        this.contact = contact;
       
    }

    public Person getPers() {
        return pers;
    }

    public void setPers(Person pers) {
        this.pers = pers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Contacts{" + "pers=" + pers + ", id=" + id + ", type=" + type + ", contact=" + contact + '}';
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
        final Contacts other = (Contacts) obj;
        return Objects.equals(this.id, other.id);
    }

}
