package store.entity.customer;

import store.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Address extends BaseEntity {

    private String street;
    private String zip;
    private String city;
    private String state;
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address copy() {
        Address copy = new Address();
        copy.setCity(city);
        copy.setCountry(country);
        copy.setState(state);
        copy.setStreet(street);
        copy.setZip(zip);
        return copy;
    }
}
