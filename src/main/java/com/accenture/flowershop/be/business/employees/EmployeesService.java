package com.accenture.flowershop.be.business.employees;

import com.accenture.flowershop.be.entity.employees.EmployeesEntity;
import com.accenture.flowershop.fe.dto.employees.EmployeesDTO;
import com.accenture.flowershop.fe.ws.UserException;

import java.util.List;

public interface EmployeesService {
    EmployeesEntity registration(EmployeesDTO employeesDTO) throws UserException;
    EmployeesEntity login(EmployeesDTO employeesDTO) throws UserException;
}
