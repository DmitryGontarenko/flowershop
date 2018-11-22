package com.accenture.flowershop.be.access.customer;

import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository("CustomerDAO")
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer findById(long customerId) {

        Customer customer = null;
        try {
            TypedQuery<Customer> query = entityManager.createNamedQuery("Customer.findById", Customer.class)
                        .setParameter("id", customerId);
            customer = query.getSingleResult();
        } catch (NoResultException ex) {

        }

        return customer;
    }

    @Override
    public Long save(Customer customer) {
        entityManager.persist(customer);
        return customer.getId();
    }
}
