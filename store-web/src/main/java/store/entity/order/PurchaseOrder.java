package store.entity.order;

import store.entity.BaseEntity;
import store.entity.customer.Address;
import store.entity.customer.Customer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PurchaseOrder extends BaseEntity {

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Address shippingAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> items = new ArrayList<>();

    public List<PurchaseOrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setItems(List<PurchaseOrderItem> items) {
        this.items = items;
    }

    public void addItem(PurchaseOrderItem item) {
        item.setOrder(this);
        items.add(item);
    }

    public void removeItem(PurchaseOrderItem item) {
        item.setOrder(null);
        items.remove(item);
    }
}
