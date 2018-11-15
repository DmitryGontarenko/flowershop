package com.accenture.flowershop.be.business.order.interfaces;

import com.accenture.flowershop.be.business.order.exceptions.OrderException;
import com.accenture.flowershop.be.entity.order.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrder();

    Order saveOrder(Order order);

    Order findOrderById(long orderId) throws OrderException;

    Order changeOrderStatusToPaid(Long orderId) throws OrderException;

    Order changeOrderStatusToClose(Long orderId) throws OrderException;
}
