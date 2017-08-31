package store.control.repository;

import store.entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class BaseRepository {

    @PersistenceContext
    EntityManager em;

    public <E> E find(Class<E> clazz, Serializable id) {
        return em.find(clazz, id);
    }

    public <E> E getReference(Class<E> clazz, Serializable id) {
        return em.getReference(clazz, id);
    }

    public BaseEntity save(BaseEntity entity) {
        if (entity.getId() == null) {
            em.persist(entity);
            return entity;
        } else {
            return em.merge(entity);
        }
    }

    public void remove(BaseEntity entity) {
        if (em.contains(entity)) {
            em.remove(entity);
        } else {
            BaseEntity reference = em.getReference(entity.getClass(), entity.getId());
            em.remove(reference);
        }
    }

    public void removeById(Class<?> clazz, Serializable id) {
        Object reference = em.getReference(clazz, id);
        em.remove(reference);
    }

    public void removeEntity(Object entity) {
        em.remove(entity);
    }

    public void detach(Object object) {
        em.detach(object);
    }

    public <T> List<T> getAll(Class<T> clazz) {
        TypedQuery<T> query = em.createQuery("select o from " + clazz.getName() + " o", clazz);
        return query.getResultList();
    }

    public <T> List<T> getAllOrderById(Class<T> clazz) {
        TypedQuery<T> query = em.createQuery("select o from " + clazz.getName() + " o order by o.id", clazz);
        return query.getResultList();
    }

    public void flush() {
        em.flush();
    }

    protected <E> E getSingleOrNullOrThrowException(TypedQuery<E> query) {
        List<E> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else if (result.size() == 1) {
            return result.get(0);
        } else {
            throw new IllegalStateException("More than one result found for query " + query.toString());
        }
    }


}
