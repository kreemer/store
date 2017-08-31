package store;

import org.junit.*;
import store.entity.Product;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class PersistenceTest {


    private static EntityManagerFactory emf;
    private static EntityManager em;
    private EntityTransaction transaction;

    @Test
    public void find() throws Exception {
        TypedQuery<Product> q = em.createQuery("select p from Product p", Product.class);
        List<Product> products = q.getResultList();

        assertFalse(products.isEmpty());
    }

    @Before
    public void before() {
        transaction = em.getTransaction();
        transaction.begin();

        Product product = new Product("Coca Cola 6 x 0.5l");
        em.persist(product);
        em.flush();
    }

    @After
    public void after() {
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }

    @BeforeClass
    public static void beforeClass() {
        emf = Persistence.createEntityManagerFactory("store");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void afterClass() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
