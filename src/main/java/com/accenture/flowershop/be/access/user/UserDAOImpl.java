package com.accenture.flowershop.be.access.user;

import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {

        List<User> users = null;

        try {
            TypedQuery<User> query = entityManager.createNamedQuery("User.findAll", User.class);
            users = query.getResultList();
        } catch (NoResultException ex) {
            users = Collections.emptyList();
            // emptyList - Метод предназначен для тех случаев, когда нужно получить пустую коллекцию, а не null.
        }
        return users;
    }

    @Override
    public User findById(long userId) {

        User user = null;

        try {
            TypedQuery<User> query = entityManager.createNamedQuery("User.findById", User.class).setParameter("id", userId);
            user = query.getSingleResult();
            // getSingleResult - предназначен для получения единственного результата
        } catch (NoResultException ex) {

        }
        return user;
    }

    @Override
    public User findByUsername(String username) {

        User user = null;

        try {
            TypedQuery<User> query  = entityManager.createNamedQuery("User.findByUsername", User.class)
                    .setParameter("username", username);
            user = query.getSingleResult();
        } catch (NoResultException nr) {

        }
        return user;
    }
}
