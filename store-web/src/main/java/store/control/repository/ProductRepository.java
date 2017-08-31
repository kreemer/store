package store.control.repository;

import store.entity.product.Product;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class ProductRepository extends BaseRepository {

    public List<Product> findProductsByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        } else {
            TypedQuery<Product> query = em.createQuery("select p from Product p where lower(p.name) like lower(:name)", Product.class);
            query.setParameter("name", "%" + name + "%");

            return query.getResultList();
        }
    }

}
