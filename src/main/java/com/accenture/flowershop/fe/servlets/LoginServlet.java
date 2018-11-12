package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.user.UserService;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet(){
        super();
    }

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDTO userDTO = new UserDTO(username, password);

        try {
            userDTO = mapper.map(userService.login(userDTO), UserDTO.class);
        } catch (UserException ex) {
            request.setAttribute("error", ex.getMessage());
            doGet(request, response);
            return;
        }

        userService.setUserSession(request.getSession(), userDTO);
        response.sendRedirect("/");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }
}
