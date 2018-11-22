package com.accenture.flowershop.be.access.order;

import com.accenture.flowershop.be.entity.order.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository("OrderDAO")
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findAll() {

        List<Order> orders = null;
        try {
            TypedQuery<Order> query =
                    entityManager.createNamedQuery("Order.findAll", Order.class);
            orders = query.getResultList();
        } catch (NoResultException ex) {
            orders = Collections.emptyList();
        }
        return orders;
    }

    @Override
    public Order findById(long orderId) {

        Order order = null;
        try {
            TypedQuery<Order> query =
                    entityManager.createNamedQuery("Order.findById", Order.class).setParameter("id", orderId);
            order = query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return order;
    }

    @Override
    public Long save(Order order) {
        entityManager.persist(order);
        return order.getId();
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }

}
