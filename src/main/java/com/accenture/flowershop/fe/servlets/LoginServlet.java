package com.accenture.flowershop.fe.servlets;


import com.accenture.flowershop.be.business.employees.EmployeesService;
import com.accenture.flowershop.fe.dto.employees.EmployeesDTO;
import com.accenture.flowershop.fe.ws.UserException;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet(){
        super();
    }

    @Autowired
    private Mapper mapper;

    @Autowired
    private EmployeesService employeesService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        EmployeesDTO employeesDTO = new EmployeesDTO(username, password);

        try {
            employeesDTO = mapper.map(employeesService.login(employeesDTO), EmployeesDTO.class);

        } catch (UserException e) {
            request.setAttribute("error", e.getMessage());
            doGet(request, response);
            return;
        }

        //response.sendRedirect(request.getContextPath() + "/");

//        UserAccount userAccount = UserDao.findUser(username, password);
//
//        if (userAccount == null) {
//            String errorMessage = "Invalid Username or Password";
//            request.setAttribute("errorString", errorMessage);
//        }
//        else {
//            request.getSession(true).setAttribute("username", username);
//        }
//
//        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);

//        HttpSession session = request.getSession();
//
//        Object username = session.getAttribute("username");
//
//        if (username != null){
//            request.setAttribute("username", username);
//            response.sendRedirect(request.getContextPath() + "/"); // Если пользователь авторизован, переход на главную
//
//        }
//
        //getServletContext().getRequestDispatcher("/login.jsp").include(request, response);

    }
}
