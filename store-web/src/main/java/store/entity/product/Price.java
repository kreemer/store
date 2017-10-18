package store.entity.product;

import store.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Price extends BaseEntity {

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date validFrom;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date validTo;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private PriceType type;

    @ManyToOne
    private Product product;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PriceType getType() {
        return type;
    }

    public void setType(PriceType type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
