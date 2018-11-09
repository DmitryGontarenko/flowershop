package com.accenture.flowershop.be.access.employees;

import com.accenture.flowershop.be.entity.employees.EmployeesEntity;

public interface EmployeesDAO {

    EmployeesEntity findEmployeeByUsername();

}
