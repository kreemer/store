package store.control.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import store.BaseTestWithEntityManager;
import store.control.repository.CustomerRepository;
import store.entity.customer.BusinessCustomer;
import store.entity.customer.PrivateCustomer;

public class CustomerRepositoryTest extends BaseTestWithEntityManager {

    private CustomerRepository customerRepository;

    @Before
    public void before() {
        customerRepository = new CustomerRepository();
        customerRepository.em = em;
    }

    @After
    public void after() {
//        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:mem:storedb", "--user", "sa", "--password", ""});
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//        }
    }

    @Test
    public void createBusinessCustomer() {
        BusinessCustomer customer = new BusinessCustomer();
        customer.setName("Universität Bern");

        customerRepository.save(customer);
    }

    @Test
    public void createPrivateCustomer() {
        PrivateCustomer customer = new PrivateCustomer();
        customer.setFirstName("Simon");
        customer.setName("Martinelli");

        customerRepository.save(customer);
    }

}
