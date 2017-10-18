package store.boundry;

import store.control.repository.OrderRepository;
import store.entity.customer.Customer;
import store.entity.order.PurchaseOrder;
import store.entity.order.PurchaseOrderItem;
import store.entity.product.Product;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ConversationScoped
public class CartBean implements Serializable {

    @Inject
    private Conversation conversation;

    @EJB
    private OrderRepository orderRepository;

    private PurchaseOrder purchaseOrder;

    public void addItem(Product product, Customer customer) {
        if (purchaseOrder == null) {
            purchaseOrder = new PurchaseOrder();
            purchaseOrder.setCustomerId(customer.getId());
            purchaseOrder.setPurchaseDate(new Date());

            conversation.begin();
        }
        PurchaseOrderItem item = new PurchaseOrderItem();
        item.setQuantity(1);
        item.setProduct(product);
        purchaseOrder.addItem(item);
        purchaseOrder = orderRepository.savePurchaseOrder(purchaseOrder);
    }

    public void removeItem(PurchaseOrderItem item) {
        purchaseOrder.removeItem(item);
    }

    public String showCart() {
        return "cart.xhtml";
    }

    public String checkout() {
        conversation.end();
        purchaseOrder = null;
        return "index.xhtml";
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
