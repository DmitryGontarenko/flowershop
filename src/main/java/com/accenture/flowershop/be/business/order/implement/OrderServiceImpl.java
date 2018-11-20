package com.accenture.flowershop.be.business.order.implement;

import com.accenture.flowershop.be.access.order.OrderDAO;
import com.accenture.flowershop.be.business.cart.CartItem;
import com.accenture.flowershop.be.business.customer.interfaces.CustomerService;
import com.accenture.flowershop.be.business.order.exceptions.OrderException;
import com.accenture.flowershop.be.business.order.interfaces.OrderService;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;
import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.fe.dto.order.OrderFormDTO;
import com.accenture.flowershop.fe.enums.order.OrderStatus;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Mapper mapper;

    @Override
    public List<Order> findAllOrder() {

        return (List<Order>) orderDAO.findAll();
    }

    @Transactional
    @Override
    public Order saveOrder(Order order) {
        orderDAO.save(order);
        return orderDAO.findById(order.getId());
    }

    @Transactional
    @Override
    public Order createOrder(OrderFormDTO orderFormDTO) throws OrderException {

        Order order = new Order();
        order.setTotal(orderFormDTO.getCart().getTotal());
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(new Date());
        order.setCustomer(customerService.findCustomerById(orderFormDTO.getCustomerId()));

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (CartItem cartItem : orderFormDTO.getCart().getItemList()) {
            Product product = mapper.map(cartItem.getProduct(), Product.class);
            orderProducts.add(new OrderProduct(product, order, cartItem.getQuantity()));
        }
        order.setOrderProducts(orderProducts);
        order = saveOrder(order);

        log.debug("Order with id = {} was created. Total sum = {}",
                order.getId(), order.getTotal());

        return order;
    }

    @Override
    public Order findOrderById(long orderId) throws OrderException {

        return orderDAO.findById(orderId);
    }

    @Transactional
    @Override
    public Order changeOrderStatusToPaid(Long orderId) throws OrderException {
        // TODO: Сделать изменение для числа продуктов при оплате
        Order order = orderDAO.findById(orderId);
        // Устанавливаем статус заказу - ОПЛАЧЕН
        order.setStatus(OrderStatus.PAID);
        // Баланс пользователя = баланс пользователя - сумма заказа
        order.getCustomer().setBalance(
                order.getCustomer().getBalance().subtract(order.getTotal()));
        // Устанавливаем новую дату обновления заказа
        order.setUpdatedAt(new Date());

        log.debug("Order with id = {} changed status to {}",
                order.getId(), order.getCustomer());

        order = saveOrder(order);
        return order;
    }

    @Transactional
    @Override
    public Order changeOrderStatusToClose(Long orderId) throws OrderException {
        Order order = orderDAO.findById(orderId);
        // Устанавливаем статус заказу - ЗАКРЫТ
        order.setStatus(OrderStatus.CLOSED);
        // Устаналиваем новую дату обновления заказа
        order.setUpdatedAt(new Date());

        log.debug("Order with id = {} changed status to {}",
                order.getId(), order.getCustomer());

        order = saveOrder(order);
        return order;

    }
}
