package com.accenture.flowershop.be.business.customer.interfaces;

import com.accenture.flowershop.be.business.customer.exceptions.CustomerException;
import com.accenture.flowershop.be.business.customer.implement.CustomerDiscount;
import com.accenture.flowershop.be.entity.customer.Customer;

public interface CustomerService {

    Customer findCustomerById(long customerId);

    void changeCustomerDiscount(CustomerDiscount customerDiscount) throws CustomerException;


}
