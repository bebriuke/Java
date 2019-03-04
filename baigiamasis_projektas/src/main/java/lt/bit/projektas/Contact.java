package lt.bit.projektas;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table (name = "contacts")
public class Contact {

    

@Id @GeneratedValue(strategy=GenerationType.IDENTITY )    private Integer id;
                                                          private String type;
                                                          private String contact;
@ManyToOne   @JoinColumn(name = "person_id")              private Person person;

    public Contact() {
        
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contact(String type, String contact) {
       
        this.type = type;
        this.contact = contact;
    }

    public Contact(Integer id, String type, String contact) {
        this.id = id;
        this.type = type;
        this.contact = contact;
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
        return "Contact{" + "id=" + id + ", type=" + type + ", contact=" + contact + '}';
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
        final Contact other = (Contact) obj;
        return Objects.equals(this.id, other.id);
    }

}
