package com.accenture.flowershop.fe.servlets.order;

import com.accenture.flowershop.be.business.order.exceptions.OrderException;
import com.accenture.flowershop.be.business.order.interfaces.OrderService;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import com.accenture.flowershop.fe.enums.user.UserRole;
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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "OrderServlet", urlPatterns = "/order") // отображение всех заказов
public class OrderServlet extends HttpServlet {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Mapper mapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        try {
            OrderDTO orderDTO = mapper.map(orderService.changeOrderStatusToClose(Long.parseLong(orderId)), OrderDTO.class);
            request.setAttribute("orders", orderDTO);
            doGet(request, response);
        } catch (OrderException ex) {
            //request.getSession().setAttribute("orderError", ex.getMessage());
            response.sendRedirect("/");
            return;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            UserDTO sessionUser = (UserDTO)session.getAttribute("user");
            if (sessionUser.getRole() == UserRole.ADMIN) {
                List<OrderDTO> orders = orderService.findAllOrder().stream()
                        .map(product -> mapper.map(product, OrderDTO.class))
                        .collect(Collectors.toList());
                request.setAttribute("orders", orders);
                request.getRequestDispatcher("/order.jsp").forward(request, response);
                return;
            } else {
                response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
