package com.accenture.flowershop.fe.servlets.product;

import com.accenture.flowershop.be.business.product.interfaces.ProductService;
import com.accenture.flowershop.be.business.product.search.ProductSearch;
import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.fe.dto.product.ProductDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/catalog")
public class ProductIndexServlet extends HttpServlet {

    @Autowired
    private ProductService productService;

    @Autowired
    private Mapper mapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDTO> productDTOS = null;

        productDTOS = productService.findAllProduct().stream().map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList());

        request.setAttribute("productlist", productDTOS);
        request.getRequestDispatcher("/catalog.jsp").forward(request, response);
    }
}
