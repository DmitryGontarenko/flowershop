package com.accenture.flowershop.be.access.product;

import com.accenture.flowershop.be.entity.product.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

public interface ProductDAO {

    List<Product> findAll();

    Product findById(long productId);

    List<Product> findByName(String name);

    List<Product> findByPartName(String productName);

    List<Product> findByPrice(BigDecimal price);

    Long save(Product product);

    void update(Product product);

    void delete(Product product);
}
