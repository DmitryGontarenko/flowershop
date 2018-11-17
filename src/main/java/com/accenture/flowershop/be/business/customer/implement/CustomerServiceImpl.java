package com.accenture.flowershop.be.business.customer.implement;

import com.accenture.flowershop.be.access.customer.CustomerDAO;
import com.accenture.flowershop.be.business.customer.interfaces.CustomerService;
import com.accenture.flowershop.be.entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer findCustomerById(long customerId) {
        return customerDAO.findById(customerId);
    }
}
