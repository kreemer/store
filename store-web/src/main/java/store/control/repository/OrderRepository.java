package store.control.repository;

import store.control.dto.PurchaseOrderInfo;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class OrderRepository extends BaseRepository {

    public List<PurchaseOrderInfo> getPurchaseOrderInfos() {
        TypedQuery<PurchaseOrderInfo> q = em.createQuery(
                "select new store.control.dto.PurchaseOrderInfo(p.id, p.purchaseDate, p.deliveryDate, count(i), sum(i.price)) " +
                        "from PurchaseOrder p join p.items i " +
                        "group by p.id, p.purchaseDate, p.deliveryDate " +
                        "order by p.purchaseDate desc ",
                PurchaseOrderInfo.class);
        return q.getResultList();
    }
}
