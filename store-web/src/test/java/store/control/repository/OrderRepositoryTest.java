package store.control.repository;

import org.junit.Before;
import org.junit.Test;
import store.BaseTestWithEntityManager;
import store.entity.order.PurchaseOrder;

public class OrderRepositoryTest extends BaseTestWithEntityManager {

    private OrderRepository orderRepository;

    @Before
    public void before() {
        orderRepository = new OrderRepository();
        orderRepository.em = em;
    }

    @Test
    public void createOrder() {
        PurchaseOrder order = new PurchaseOrder();

        orderRepository.save(order);
    }

}
