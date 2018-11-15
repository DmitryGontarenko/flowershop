package com.accenture.flowershop.be.access.order;

import com.accenture.flowershop.be.entity.order.Order;

import java.util.List;

public interface OrderDAO {

    List<Order> findAll();

    Order findById(long orderId);

    Long save(Order order);

    void update(Order order);

    void delete(long orderId);
}
