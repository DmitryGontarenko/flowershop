package com.accenture.flowershop.be.business.product.interfaces;

import com.accenture.flowershop.be.entity.product.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();
    List<Product> findProductByName(String productName);
//  List<Product> findProductByRangePrice(BigDecimal min, BigDecimal max);
    Product getProductById(long productId);
    void changeProductQuantityInStock(Long productId, int quantity);
}
