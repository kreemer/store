package store.control.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseOrderInfo {

    private final Integer orderId;
    private final Date purchaseDate;
    private final Date deliveryDate;
    private final long numberOfItems;
    private final BigDecimal totalAmount;

    public PurchaseOrderInfo(Integer orderId, Date purchaseDate, Date deliveryDate, long numberOfItems, BigDecimal totalAmount) {
        this.orderId = orderId;
        this.purchaseDate = purchaseDate;
        this.deliveryDate = deliveryDate;
        this.numberOfItems = numberOfItems;
        this.totalAmount = totalAmount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public long getNumberOfItems() {
        return numberOfItems;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
