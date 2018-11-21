package com.accenture.flowershop.fe.servlets.cart;

import com.accenture.flowershop.be.business.order.exceptions.OrderException;
import com.accenture.flowershop.be.business.order.interfaces.OrderService;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.order.OrderFormDTO;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Mapper mapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            // Берем данные из формы
            UserDTO userDTO = (UserDTO)session.getAttribute("user");
            OrderFormDTO orderFormDTO = new OrderFormDTO(userDTO.getCustomer().getId(),
                    request.getParameter("firstName"), request.getParameter("lastName"),
                    request.getParameter("phone"), request.getParameter("city"),
                    request.getParameter("street"), request.getParameter("country"),
                    userDTO.getCustomer().getCart());

            // Создаем новый заказ
            OrderDTO orderDTO = null;
            try {
                orderDTO = mapper.map(orderService.createOrder(orderFormDTO), OrderDTO.class);
            } catch (OrderException ex) {
                //request.setAttribute("error", ex.getMessage());
                doGet(request, response);
                return;
            }

            userDTO.getCustomer().getCart().removeAllItem();
            response.sendRedirect("/view?id=" + orderDTO.getId());

        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED); //401
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED); // 401
        }
    }
}
