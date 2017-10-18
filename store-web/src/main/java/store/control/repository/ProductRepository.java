package store.control.repository;

import store.entity.product.Product;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProductRepository extends BaseRepository {

    public List<Product> findProductsByName(String name) {
        if (name == null) {
            TypedQuery<Product> query = em.createQuery("select p from Product p join fetch p.prices pr order by p.name",
                    Product.class);
            return query.getResultList();

        } else {
            TypedQuery<Product> query = em.createQuery("select p from Product p join fetch p.prices pr " +
                    "where lower(p.name) like lower(:name) order by p.name", Product.class);
            query.setParameter("name", "%" + name + "%");
            return query.getResultList();
        }
    }

}
