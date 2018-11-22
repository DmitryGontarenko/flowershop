package com.accenture.flowershop.be.access.orderproduct;

import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;

import java.util.List;

public interface OrderProductDAO {

    /**
     * Возвращает список всех объектов OrderProduct
     * @return Лист OrderProduct
     */
    List<OrderProduct> findAll();

    /**
     * Возвращает экземпляр OrderProduct по указанному ID
     * @param orderProductId ID OrderProduct
     * @return OrderProduct объект
     */
    OrderProduct findById(long orderProductId);

    /**
     * TODO: save
     * @param orderProduct Объект OrderProduct
     * @return Идентификатор записи
     */
    Long save(OrderProduct orderProduct);

}
