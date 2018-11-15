package com.accenture.flowershop.fe.dto.order;

import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.fe.enums.order.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDTO {
    private long id;
    private BigDecimal total;
    private OrderStatus status;
    private Date createdAt;
    private Date updatedAt;
    private Customer customer;

    public OrderDTO() {
    }

    public OrderDTO(long id, BigDecimal total, OrderStatus status, Date createdAt, Date updatedAt, Customer customer) {
        this.id = id;
        this.total = total;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
