package lt.bit.data;

import java.util.Objects;

public class Address {

    private static int nextId = 0;

    private Integer id;
    private String address;
    private String city;
    private String postalCode;

    public Address() {
        this.id = ++nextId;
    }

    public Address(String address, String city, String postalCode) {
        this.id = ++nextId;
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
        this.id = ++nextId;
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
