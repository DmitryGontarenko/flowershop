package com.accenture.flowershop.be.business.employees;

import com.accenture.flowershop.be.access.employees.EmployeesDAO;
import com.accenture.flowershop.be.entity.employees.EmployeesEntity;
import com.accenture.flowershop.fe.dto.employees.EmployeesDTO;
import com.accenture.flowershop.fe.ws.UserException;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("EmployeesServiceImpl")
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private EmployeesDAO employeesDAO;

    @Transactional
    @Override
    public EmployeesEntity registration(EmployeesDTO employeesDTO) throws UserException {

        EmployeesEntity employeesEntity = mapper.map(employeesDTO, EmployeesEntity.class);

        return employeesEntity;
    }

    @Override
    public EmployeesEntity login(EmployeesDTO employeesDTO) throws UserException {
        EmployeesEntity employeesFindByUsername = employeesDAO.findEmployeeByUsername();

        EmployeesEntity detectedEmployee = null;
        if (employeesFindByUsername != null) {
            detectedEmployee = employeesFindByUsername;
        }

        return detectedEmployee;


    }

}
