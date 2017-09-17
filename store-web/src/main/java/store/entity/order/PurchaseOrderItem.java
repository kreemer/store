package store.entity.order;

import store.entity.BaseEntity;
import store.entity.product.PriceType;
import store.entity.product.Product;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class PurchaseOrderItem extends BaseEntity {

    private int quantity;
    private BigDecimal price;
    private PriceType priceType;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
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

    @Access(AccessType.PROPERTY)
    public BigDecimal getTotalPrice() {
        return product.getPrices().get(0).getAmount().multiply(new BigDecimal(quantity));
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        // Ignore
    }
}
