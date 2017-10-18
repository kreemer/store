package store.control.repository;

import store.entity.customer.Customer;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class CustomerRepository extends BaseRepository {

    public Customer findCustomerByUsername(String username) {
        TypedQuery<Customer> q = em.createQuery("select c from Customer c where c.username = :username", Customer.class);
        q.setParameter("username", username);
        return q.getSingleResult();
    }
}
