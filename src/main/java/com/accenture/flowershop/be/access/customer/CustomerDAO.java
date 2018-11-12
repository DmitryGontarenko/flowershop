package com.accenture.flowershop.be.access.customer;

import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.user.User;

public interface CustomerDAO {

    Customer findById(long customerId);

    Long save (Customer customer);

    void update (Customer customer);
}
