package com.accenture.flowershop.be.access.order;

import com.accenture.flowershop.be.entity.order.Order;

import java.util.List;

public interface OrderDAO {

    /**
     * Возвращает список всех объектов Order
     * @return Лист Order
     */
    List<Order> findAll();

    /**
     * Возвращает экземпляр Order по указанному ID
     * @param orderId ID Заказа
     * @return Order объект
     */
    Order findById(long orderId);

    /**
     * TODO: save
     * @param order Объект Order
     * @return Идентификатор записи
     */
    Long save(Order order);

    /**
     * Обновляет существующий Заказ
     * @param order Объект Order содержащий информацию для обновления
     */
    void update(Order order);

}
