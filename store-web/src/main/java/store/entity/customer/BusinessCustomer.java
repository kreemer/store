package store.entity.customer;

import javax.persistence.Entity;

@Entity
public class BusinessCustomer extends Customer{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
