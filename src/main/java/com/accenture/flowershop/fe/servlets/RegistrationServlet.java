package com.accenture.flowershop.fe.servlets;


import com.accenture.flowershop.be.business.employees.EmployeesService;
import com.accenture.flowershop.fe.dto.employees.EmployeesDTO;
import com.accenture.flowershop.fe.ws.UserException;
import com.accenture.flowershop.fe.ws.UserService;
import com.accenture.flowershop.fe.ws.UserDTO;
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


//@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private Mapper mapper;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserDTO userDTO;
//
//    @Autowired
//    private Mapper mapper;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
//        getServletContext().getRequestDispatcher("/registration.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        UserDTO userDTO = new UserDTO(
//                req.getParameter("username"), req.getParameter("password") );
//
//
//        try {
//            userDTO = mapper.map(userService.registration(userDTO), UserDTO.class);
//        } catch (UserException e) {
//            req.setAttribute("error", e.getMessage());
//            doGet(req, resp);
//            return;
//        }
        String reg_username = req.getParameter("reg_username");
        String reg_password = req.getParameter("reg_password");

        EmployeesDTO employeesDTO = new EmployeesDTO(
                req.getParameter(reg_username), req.getParameter(reg_password));

        try {
            employeesDTO = mapper.map(employeesService.registration(employeesDTO), EmployeesDTO.class);
        } catch (UserException e) {
            doGet(req, resp);
            return;
        }

    }
}
