package com.accenture.flowershop.be.business.customer.implement;

import com.accenture.flowershop.be.access.customer.CustomerDAO;
import com.accenture.flowershop.be.business.customer.exceptions.CustomerException;
import com.accenture.flowershop.be.business.customer.interfaces.CustomerService;
import com.accenture.flowershop.be.entity.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Override
    public Customer findCustomerById(long customerId) {
        return customerDAO.findById(customerId);
    }

    @Transactional
    @Override
    public void changeCustomerDiscount(CustomerDiscount customerDiscount) throws CustomerException {
        Customer customer = customerDAO.findById(customerDiscount.getCustomerId());
        if(customerDiscount.newDiscount > 0  &&  customerDiscount.newDiscount < 100)
        {
            log.debug("Customer with id = {}, changed discount from {} to {}",
                    customer.getId(), customer.getDiscount(), customerDiscount.getNewDiscount());
            customer.setDiscount(customerDiscount.newDiscount);
            customerDAO.save(customer);
        }
    }
}
