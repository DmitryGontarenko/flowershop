package com.accenture.flowershop.fe.ws;


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


@WebServlet(urlPatterns = "/test")
public class Servlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper mapper;


    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String reg_username = request.getParameter("reg_username");
//        String reg_password = request.getParameter("reg_password");
//
//        try {
//            EmployeesEntity employeesEntity = new EmployeesEntity();
//            employeesEntity.setName(reg_username);
//            employeesEntity.setPassword(reg_password);
//
//            em.getTransaction().begin();
//            em.persist(employeesEntity);
//            em.getTransaction().commit();
//            response.sendRedirect(request.getContextPath() + "/login"); // Если пользователь зарегистрировался, переходит на стр. логина
//        } catch (Throwable ex) {
//            ex.printStackTrace();
//        }
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        UserDTO userDTO = new UserDTO(username, password);
//
//        try {
//            userDTO = mapper.map(userService.login(userDTO), UserDTO.class);
//        } catch (UserException e) {
//            String errorMessage = "Invalid Username or Password";
//            req.setAttribute("errorString", errorMessage);
//            doGet(req, resp);
//            return;
//        }
//
//        userService.setUserSession(req.getSession(), userDTO);
//        resp.sendRedirect("/");

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getServletContext().getRequestDispatcher("/registration.jsp").include(request, response);

        req.getRequestDispatcher("/login.jsp").forward(req, resp);


    }
}
