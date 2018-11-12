package com.accenture.flowershop.fe.servlets;


import com.accenture.flowershop.be.business.user.UserService;
import com.accenture.flowershop.fe.dto.customer.CustomerDTO;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import com.accenture.flowershop.be.business.exeptions.UserException;

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


@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerDTO customerDTO = new CustomerDTO(
                request.getParameter("firstName"), request.getParameter("lastName"));
        UserDTO userDTO = new UserDTO(
                request.getParameter("username"), request.getParameter("password"));

        userDTO.setCustomer(customerDTO);

        // Регистрация пользователя, при ошибки выведется сообщение и перезагрузится страницы
        try {
            userDTO = mapper.map(userService.register(userDTO), UserDTO.class);
        } catch (UserException ex) {
            request.setAttribute("error", ex.getMessage());
            doGet(request, response);
            return;
        }

        // Если ошибки не было, открываем сессию пользователю и переводим на главную страницу
        userService.setUserSession(request.getSession(), userDTO);
        response.sendRedirect("/");
    }

}
