package com.accenture.flowershop.fe.ws;


import com.accenture.flowershop.be.access.product.ProductDAO;
import com.accenture.flowershop.be.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.List;

@Service("ProductStockWebService")
@WebService(endpointInterface = "com.accenture.flowershop.fe.ws.ProductStockWebService")
public class ProductStockWebServiceImpl implements ProductStockWebService {

    @Autowired
    private ProductDAO productDAO;

    @Transactional
    @Override
    public void increaseProductStockSize(int count) {
        List<Product> products = (List<Product>) productDAO.findAll();
        for (Product product : products) {
            product.setInStock(product.getInStock() + count);
            productDAO.save(product);
        }
    }
}
