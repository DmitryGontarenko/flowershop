package com.accenture.flowershop.be.access.customer;

import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.user.User;

public interface CustomerDAO {

    /**
     * Возвращает экземпляр Customer по указанному ID
     * @param customerId ID Адреса
     * @return Customer объект
     */
    Customer findById(long customerId);

    /**
     * TODO: save
     * @param customer Объект Customer
     * @return Идентификатор записи
     */
    Long save (Customer customer);

}
