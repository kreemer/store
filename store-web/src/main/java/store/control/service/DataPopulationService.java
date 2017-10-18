package store.control.service;

import store.control.repository.ProductRepository;
import store.entity.product.Price;
import store.entity.product.PriceType;
import store.entity.product.Product;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.math.BigDecimal;

@Singleton
@Startup
public class DataPopulationService {

    @EJB
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        Product product = new Product();
        product.setNumber("100001");
        product.setName("Pen");
        Price price = new Price();
        price.setType(PriceType.STANDARD);
        price.setAmount(new BigDecimal("1.25"));
        product.addPrice(price);

        productRepository.save(product);

        product = new Product();
        product.setNumber("100002");
        product.setName("Knife");
        price = new Price();
        price.setType(PriceType.STANDARD);
        price.setAmount(new BigDecimal("2.00"));
        product.addPrice(price);

        productRepository.save(product);
    }
}
