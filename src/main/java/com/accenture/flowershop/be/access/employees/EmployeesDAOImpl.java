package com.accenture.flowershop.be.access.employees;

import com.accenture.flowershop.be.entity.employees.EmployeesEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service
public class EmployeesDAOImpl implements EmployeesDAO {

    @PersistenceContext
    private EntityManager em;

    public EmployeesEntity findEmployeeByUsername() {

        EmployeesEntity employeesEntity = null;

        try {
            TypedQuery<EmployeesEntity> q = em.createNamedQuery("findEmployeesById", EmployeesEntity.class)
                    .setParameter("n", "new_user");
            //List<EmployeesEntity> list = q.getResultList();
            employeesEntity = q.getSingleResult();

        } catch (Throwable e) {

        }
        return employeesEntity;
    }




}
