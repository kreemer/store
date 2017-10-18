package store.entity.customer;

import javax.persistence.Entity;

@Entity
public class PrivateCustomer extends Customer{

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
