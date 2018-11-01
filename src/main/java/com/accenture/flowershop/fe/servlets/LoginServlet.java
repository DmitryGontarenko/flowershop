package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.access.UserDao;
import com.accenture.flowershop.be.entity.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet(){
        super();
    }

    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        if("admin".equals(username) && "admin".equals(password))
//            request.getSession(true).setAttribute("username", username);

        for (User item : userDao.getAllUsers()) {
            if(item.getName().equals(username) && item.getPassword().equals(password)){
                request.getSession(true).setAttribute("username", username);
            }
            else {
                String errorMessage = "Invalid Username or Password";
                request.setAttribute("errorString", errorMessage);
            }
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        Object username = session.getAttribute("username");

        if (username != null){
            request.setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/"); // Если пользователь авторизован, переход на главную
        }

        getServletContext().getRequestDispatcher("/login.jsp").include(request, response);

    }
}
