package com.accenture.flowershop.fe.dto.orderproduct;

import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.product.ProductDTO;
import org.dozer.Mapping;

public class OrderProductDTO {

    private long id;
    private ProductDTO productDTO;
    private OrderDTO order;
    private int quantity;

    public OrderProductDTO() {
    }

    public OrderProductDTO(long id, ProductDTO productDTO, OrderDTO order, int quantity) {
        this.id = id;
        this.productDTO = productDTO;
        this.order = order;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
