package com.accenture.flowershop.be.entity.orderproduct;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.product.Product;

import javax.persistence.*;

/**
 * Сущность для таблицы order_product
 * Здесь хранится основная информация по заказу:
 * продукт,
 * заказ
 * количество
 */
@Entity
@Table(name = "tb_order_product")
@NamedQueries({
        @NamedQuery(name = "OrderProduct.findAll", query = "SELECT o FROM OrderProduct o"),
        @NamedQuery(name = "OrderProduct.findById", query = "SELECT o FROM OrderProduct o WHERE o.id = :id")
})
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity")
    private int quantity;

    public OrderProduct() {
    }

    public OrderProduct(Product product, Order order, int quantity) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + order +
                ", quantity=" + quantity +
                '}';
    }
}
