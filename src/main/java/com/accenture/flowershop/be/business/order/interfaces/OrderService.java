package com.accenture.flowershop.be.business.order.interfaces;

import com.accenture.flowershop.be.business.order.exceptions.OrderException;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.fe.dto.order.OrderFormDTO;
import org.codehaus.jackson.map.util.ArrayBuilders;

import java.util.List;

/**
 * Сервис для взаимодействия с заказами
 */
public interface OrderService {

    /**
     * Этот метод найдет все существующие заказы
     * @return Колекци Order
     */
    List<Order> findAllOrder();

    /**
     * Этот метод сохранит новый заказ
     * @param order Новый заказ
     * @return Сохраненный заказ
     */
    Order saveOrder(Order order);

    /**
     * Этот метод создаст новый заказ и провалидирует данные в объекте OrderForm
     * @param orderFormDTO объект OrderForm с сохраннеными полями из формы и корзиной
     * @return Новый заказ
     * @throws OrderException
     */
    Order createOrder(OrderFormDTO orderFormDTO) throws OrderException;

    /**
     * Этот метод найдет заказ по соответсвующему ему Id
     * @param orderId Id Заказа
     * @return Найденный заказ
     */
    Order findOrderById(long orderId) throws OrderException;

    /**
     * Этот метод изменит статус заказа на - Оплачено.
     * Изменит(уменьшит) количество продуктов на складе, которые соотвествую данному заказу
     * Снимет деньги с баланса покупателя
     * @param orderId id Заказа
     * @return Измененный заказ
     */
    Order changeOrderStatusToPaid(Long orderId) throws OrderException;

    /**
     * Этот метод изменит статус заказа на - Закрыт и назначет дату закрытия заказа
     * @param orderId id Заказа
     * @return Измененный заказ
     */
    Order changeOrderStatusToClose(Long orderId) throws OrderException;

    /**
     * Этот метод проверяет пренадлежность id заказа к id пользователя
     * @param orderId id заказа
     * @param userId id заказа
     * @return true - если id заказа принадлежит id пользователя
     */
    Boolean orderBelongToUser(Long orderId, Long userId);
}
