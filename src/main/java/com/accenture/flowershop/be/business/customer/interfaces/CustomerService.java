package com.accenture.flowershop.be.business.customer.interfaces;

import com.accenture.flowershop.be.entity.customer.Customer;

public interface CustomerService {

    Customer findCustomerById(long customerId);


}
