package store.control.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import store.BaseTestWithEntityManager;
import store.control.repository.ProductRepository;
import store.entity.product.Product;

import java.util.List;

public class ProductRepositoryTest extends BaseTestWithEntityManager {

    private ProductRepository productRepository;

    @Test
    public void searchProducts() {
        List<Product> products = productRepository.findProductsByName("stabilo");

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
        product.setName("Stabilo Marker gelb");

        productRepository.save(product);
    }
}
