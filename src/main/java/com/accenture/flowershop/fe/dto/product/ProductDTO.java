package com.accenture.flowershop.fe.dto.product;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDTO {

    private long id;
    private String name;
    private BigDecimal price;
    private int inStock;
    private Date createdAt;
    private Date updateAt;

    public ProductDTO() {
    }

    public ProductDTO(long id, String name, BigDecimal price, int inStock, Date createdAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
