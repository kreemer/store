package store.entity.order;

import store.entity.BaseEntity;
import store.entity.product.Product;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.Order;

@Entity
public class PurchaseOrderItem extends BaseEntity {

    private int quantity;
    @ManyToOne
    private PurchaseOrder order;
    @ManyToOne
    private Product product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }
}
