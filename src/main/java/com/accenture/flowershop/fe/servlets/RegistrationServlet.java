package com.accenture.flowershop.fe.servlets;

//import com.accenture.flowershop.be.entity.order.Orders;
//import com.accenture.flowershop.be.entity.order.OrdersModel;
import com.accenture.flowershop.be.entity.order.OrdersModel;
import com.accenture.flowershop.be.entity.user.EmployeesEntity;
import com.accenture.flowershop.be.entity.user.UserAccount;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
//import org.h2.engine.Session;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Autowired
    EmployeesEntity employeesEntity;

    @PersistenceContext
    private EntityManager em;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reg_username = request.getParameter("reg_username");
        String reg_password = request.getParameter("reg_password");

//        try (Session session = OrdersModel.getSession())
//        {
//            session.beginTransaction();
//            EmployeesEntity employeesEntity = new EmployeesEntity();
//            employeesEntity.setName(reg_username);
//            employeesEntity.setPassword(reg_password);
//            session.save(employeesEntity);
//            session.getTransaction().commit();
//
//            response.sendRedirect(request.getContextPath() + "/login"); // Если пользователь зарегистрировался, переходит на стр. логина
//
//        } catch (Throwable ex) {
//            ex.printStackTrace();
//        }

        try {
            EmployeesEntity employeesEntity = new EmployeesEntity();
            employeesEntity.setName(reg_username);
            employeesEntity.setPassword(reg_password);

            em.getTransaction().begin();
            em.persist(employeesEntity);
            em.getTransaction().commit();

            response.sendRedirect(request.getContextPath() + "/login"); // Если пользователь зарегистрировался, переходит на стр. логина

        } catch (Throwable ex) {
            ex.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/registration.jsp").include(request, response);

    }
}
