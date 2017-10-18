package store.control.repository;

import org.junit.Before;
import org.junit.Test;
import store.BaseTestWithEntityManager;
import store.entity.dto.PurchaseOrderInfo;
import store.entity.order.PurchaseOrder;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderRepositoryTest extends BaseTestWithEntityManager {

    private OrderRepository orderRepository;

    @Before
    public void before() {
        orderRepository = new OrderRepository();
        orderRepository.em = em;
    }

    @Test
    public void getPurchaseOrderInfos() {
        PurchaseOrder order = new PurchaseOrder();
        orderRepository.save(order);
        em.flush();

        List<PurchaseOrderInfo> purchaseOrderInfos = orderRepository.getPurchaseOrderInfos();

        assertEquals(0, purchaseOrderInfos.size());
    }
}
