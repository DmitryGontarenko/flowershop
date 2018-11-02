package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.entity.user.UserAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

//    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataSource");
//    public static EntityManager em = emf.createEntityManager();
    private EntityManager em;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("reg_username");
        String password = request.getParameter("reg_password");

//        UserAccount cust1 = new UserAccount(username, password);
//        em.getTransaction().begin();
//        em.persist(cust1);
//        em.getTransaction().commit();
        UserAccount cust1 = new UserAccount(username, password);
        em.getTransaction().begin();
        em.persist(cust1);
        em.getTransaction().commit();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/registration.jsp").include(request, response);

    }
}
