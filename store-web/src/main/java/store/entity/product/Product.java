package store.entity.product;

import store.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "validFrom")
    private List<Price> prices = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public void addPrice(Price price) {
        price.setProduct(this);
        prices.add(price);
    }
}
