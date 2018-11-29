package lt.bit.data;

import java.util.Objects;

public class Contact {

    private static int nextId = 0;

    private Integer id;
    private String type;
    private String contact;

    public Contact() {
        this.id = ++nextId;
    }

    public Contact(String type, String contact) {
        this.id = ++nextId;
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

    public void createId() {
        this.id = ++nextId;
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
