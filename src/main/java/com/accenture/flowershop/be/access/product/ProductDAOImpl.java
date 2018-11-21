package com.accenture.flowershop.be.access.product;

import com.accenture.flowershop.be.entity.product.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {

        List<Product> products = null;
        try {
            TypedQuery<Product> query =
                    entityManager.createNamedQuery("Product.findAll", Product.class);
            products = query.getResultList();
        } catch (NoResultException ex) {
            products = Collections.emptyList();
        }
        return products;
    }

    @Override
    public Product findById(long productId) {

        Product products = null;

        try {
            TypedQuery<Product> query =
                    entityManager.createNamedQuery("Product.findById", Product.class)
                            .setParameter("id", productId);
            products = query.getSingleResult();
        } catch (NoResultException ex) {

        }
        return products;
    }

    @Override
    public List<Product> findByName(String name) {

        List<Product> products = null;
        try{
            TypedQuery<Product> query
                    = entityManager.createNamedQuery("Product.findByName", Product.class)
                    .setParameter("name", name);
            products = query.getResultList();
        } catch (NoResultException ex) {
            products = Collections.emptyList();
        }
        return products;
    }

    @Override
    public List<Product> findByPartName(String productName) {
        List<Product> products = null;
        try {
            TypedQuery<Product> query =
                    entityManager.createNamedQuery("Product.findByPartName", Product.class)
                            .setParameter("productName", "%" + productName + "%");
            products = query.getResultList();
        } catch (NoResultException ex) {
            products = Collections.emptyList();
        }
        return products;

    }


    @Override
    public List<Product> findByPrice(BigDecimal price) {

        List<Product> products = null;
        try {
            TypedQuery<Product> query
                    = entityManager.createNamedQuery("Product.findByPrice", Product.class)
                    .setParameter("price", price);
            products = query.getResultList();
        } catch (NoResultException ex) {
            products = Collections.emptyList();
        }
        return products;
    }

    @Override
    public Long save(Product product) {
        entityManager.persist(product);
        return product.getId();
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(Product product) {

    }
}
