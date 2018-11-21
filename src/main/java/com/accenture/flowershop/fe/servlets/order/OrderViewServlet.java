package com.accenture.flowershop.fe.servlets.order;

import com.accenture.flowershop.be.business.exeptions.UserException;
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

@WebServlet(name = "OrderViewServlet", urlPatterns = "/view")
public class OrderViewServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null && request.getParameter("orderId") != null) {
            // Берем пользователя из сессия, id заказа и оформляем заказ
            UserDTO userDTO = (UserDTO)session.getAttribute("user");
            String orderId = request.getParameter("orderId");
            OrderDTO orderDTO = null;

            try {
                orderDTO = mapper.map(orderService.changeOrderStatusToPaid(Long.parseLong(orderId)), OrderDTO.class);

            } catch (OrderException e) {
//                request.getSession().getAttribute("error", e.getMessage());
//                response.sendRedirect("/view?id="+orderId);
//                return;
            }
            // Если ошибок не возникло
            // Изменяем баланс у пользователя в сессии и перенаправляем на нужную страницу

            userDTO.getCustomer().setBalance(orderDTO.getCustomer().getBalance());
            response.sendRedirect("/catalog");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
        String orderId = request.getParameter("id");
        OrderDTO orderDTO = null;
        // Если GET параметр на заказ присутствует, то формируем заказ
        // Если заказ не найден, то формируем ошибку
        if (orderId != null) {
            try {
                orderDTO = mapper.map(orderService.findOrderById(Long.parseLong(orderId)), OrderDTO.class);

            } catch (OrderException e) {
                request.setAttribute("error", e.getMessage());
                //request.getRequestDispatcher("/page_error.jsp").forward(request, response);
                return;
            }
        }

        // Если заказ существует и пользователь авторизован то показываем заказ или выдаем ошибку
        if (userDTO != null && orderDTO != null) {
            // Если заказ принадлежит аворизованному пользователю или это администратор,
            // показываем, иначе выдается ошибку
            if(orderService.orderBelongToUser(orderDTO.getId(), userDTO.getId()) || userDTO.getRole().equals(UserRole.ADMIN)){
                request.setAttribute("order", orderDTO);
                request.getRequestDispatcher("/view.jsp").forward(request, response);
            } else {
//                request.setAttribute("error", UserException.USER_UNAUTHORIZED);
//                request.getRequestDispatcher("/error_page.jsp").forward(request, response);
            }

        } else {
//            request.setAttribute("error", UserException.USER_UNAUTHORIZED);
//            request.getRequestDispatcher("error_page.jsp").forward(request, response);
        }
    }
}
