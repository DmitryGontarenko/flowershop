package com.accenture.flowershop.be.business.product.implement;

import com.accenture.flowershop.be.access.product.ProductDAO;
import com.accenture.flowershop.be.business.product.interfaces.ProductService;
import com.accenture.flowershop.be.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> findAllProduct() {

        List<Product> products = (List<Product>)productDAO.findAll();
        return products.stream().filter(product -> product.getInStock() > 0).collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductByPartName(String productName) {
        if(productName != null && !productName.isEmpty()) {
            // Меняем кодировку для отображения товаров на русском языке
            try {
                byte etext[] = productName.getBytes("ISO-8859-1");
                productName = new String(etext, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        List<Product> products = productDAO.findByPartName(productName);
        return products.stream().filter(product -> product.getInStock() > 0).collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductByName(String productName) {
        List<Product> products = productDAO.findByName(productName);
        return products.stream().filter(product -> product.getInStock() > 0 ).collect(Collectors.toList());
    }

    @Override
    public Product getProductById(long productId) {
        return productDAO.findById(productId);
    }

    @Override
    public void changeProductQuantityInStock(Long productId, int quantity) {
        Product product = productDAO.findById(productId);
        int inStock = product.getInStock();
        if (inStock > quantity) {
            product.setInStock(inStock - quantity);
        }
        productDAO.save(product);
    }
}
