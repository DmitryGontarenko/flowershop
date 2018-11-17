package com.accenture.flowershop.be.access.orderproduct;

import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;

import java.util.List;

public interface OrderProductDAO {

    List<OrderProduct> findAll();

    OrderProduct findById(long orderProductId);

    Long save(OrderProduct orderProduct);

    void delete(long orderProduct);
}
