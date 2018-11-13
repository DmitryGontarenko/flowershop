package com.accenture.flowershop.be.entity.product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_product")
@NamedQueries({
        @NamedQuery(name = "Product.findAll",
                query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findById",
                query = "SELECT p FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = "Product.findByName",
                query = "SELECT p FROM Product p WHERE p.name = :name"),
        @NamedQuery(name = "Product.findByPrice",
                query = "SELECT p FROM Product p WHERE p.price = :price")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price", precision = 6, scale = 2)
    private BigDecimal price;

    @Column(name = "in_stock")
    private int inStock;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    public Product() {
    }

    public Product(long id, String name, BigDecimal price, int inStock, Date createdAt, Date updateAt) {
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
