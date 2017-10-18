package store.control.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import store.BaseTestWithEntityManager;
import store.entity.product.Price;
import store.entity.product.PriceType;
import store.entity.product.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductRepositoryTest extends BaseTestWithEntityManager {

    private ProductRepository productRepository;

    @Test
    public void searchProducts() {
        List<Product> products = productRepository.findProductsByName("Pen");

        Assert.assertEquals(1, products.size());
    }

    @Before
    public void before() {
        productRepository = new ProductRepository();
        productRepository.em = em;

        createProduct();
    }

    private void createProduct() {
        Product product = new Product();
        product.setNumber("100001");
        product.setName("Pen");
        Price price = new Price();
        price.setType(PriceType.STANDARD);
        price.setAmount(new BigDecimal("1.25"));
        product.addPrice(price);

        productRepository.save(product);    }
}
