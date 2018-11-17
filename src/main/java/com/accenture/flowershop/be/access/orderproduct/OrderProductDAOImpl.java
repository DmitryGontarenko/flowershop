package com.accenture.flowershop.be.access.orderproduct;

import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository("OrderProductDAO")
public class OrderProductDAOImpl implements OrderProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OrderProduct> findAll() {
        List<OrderProduct> orderProducts = null;
        try {
            TypedQuery<OrderProduct> query = entityManager.createNamedQuery("OrderProduct.findAll", OrderProduct.class);
            orderProducts = query.getResultList();
        } catch (NoResultException ex) {
            orderProducts = Collections.emptyList();
        }
        return orderProducts;
    }

    @Override
    public OrderProduct findById(long orderProductId) {
        OrderProduct orderProducts = null;
        try {
            TypedQuery<OrderProduct> query = entityManager.createNamedQuery("OrderProduct.findById", OrderProduct.class)
                    .setParameter("id", orderProductId);
            orderProducts = query.getSingleResult();
        } catch (NoResultException ex) {
        }
        return orderProducts;
    }

    @Override
    public Long save(OrderProduct orderProduct) {
        entityManager.persist(orderProduct);
        return orderProduct.getId();
    }

    @Override
    public void delete(long orderProduct) {

    }
}
