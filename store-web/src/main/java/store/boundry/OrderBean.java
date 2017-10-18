package store.boundry;

import store.control.repository.OrderRepository;
import store.entity.customer.Customer;
import store.entity.dto.PurchaseOrderInfo;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class OrderBean implements Serializable {

    @EJB
    private OrderRepository orderRepository;

    private List<PurchaseOrderInfo> orders = new ArrayList<>();

    public String showOrders(Customer customer) {
        orders = orderRepository.getPurchaseOrderInfos(customer.getId());

        return "orders.xhtml";
    }

    public List<PurchaseOrderInfo> getOrders() {
        return orders;
    }

    public void setOrders(List<PurchaseOrderInfo> orders) {
        this.orders = orders;
    }
}
