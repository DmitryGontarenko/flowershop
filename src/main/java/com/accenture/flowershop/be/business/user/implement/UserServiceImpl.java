package com.accenture.flowershop.be.business.user.implement;

import com.accenture.flowershop.be.access.user.UserDAO;
import com.accenture.flowershop.be.business.user.interfaces.UserMarshallingService;
import com.accenture.flowershop.be.business.user.interfaces.UserService;
import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import com.accenture.flowershop.fe.enums.user.UserRole;
import com.accenture.flowershop.be.business.exeptions.UserException;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserMarshallingService userMarshallingService;

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userDAO.findAll();
    }

    @Override
    public User saveUser(User user) {
        userDAO.save(user);
        return userDAO.findById(user.getId());
    }

    @Override
    public User login(UserDTO userDTO) throws UserException {

        StringBuilder errors = new StringBuilder();

        // validation

        // Проверка на совпадение
        User userFindByUsername = userDAO.findByUsername(userDTO.getUsername());

        if (userFindByUsername == null) {
            errors.append("Пользователь с таким логином не найден");
            throw new UserException(errors.toString());
        }

        User detectedUser = null;

        if (userFindByUsername != null) {
            detectedUser = userFindByUsername;
        }

        // Проверка введенного пароля
        if (!detectedUser.getPassword().equals(userDTO.getPassword())) {
            errors.append("Проверьте правильность введенного пароля");
            throw new UserException(errors.toString());
        }

        log.debug("User with id = {}, username = {}, was entered",
                detectedUser.getId(), detectedUser.getUsername());

        return detectedUser;
    }

    @Transactional
    @Override
    public User register(UserDTO userDTO) throws UserException {

        StringBuilder errors = new StringBuilder();

        // validation

        User user = mapper.map(userDTO, User.class);
        user.setRole(UserRole.USER);
        user.setCreatedUpdate(new Date(), new Date());

        Customer customer = mapper.map(userDTO.getCustomer(), Customer.class);
        customer.setBalance(new BigDecimal(2000));
        customer.setDiscount(3);

        user.setCustomer(customer);
        customer.setUser(user);

        user = saveUser(user);
        UserXML(user); // XML Conventer
        log.debug("User with id = {}, username = {} was registered",
                user.getId(), user.getUsername());

        return user;
    }

    @Override
    public void setUserSession(HttpSession session, UserDTO userDTO) {
        session.setAttribute("user", userDTO);
    }

    @Override
    public void UserXML(User user) {
        try {
            // load properties
            Properties properties = new Properties();
            InputStream propertyInputStream =
                    getClass().getClassLoader().getResourceAsStream("conf.properties");
            properties.load(propertyInputStream);

            // create xml file
            userMarshallingService.convertFromUserToXML(user, properties.getProperty("user.xml.path"));

            // read xml file and send
            FileInputStream xmlInputStream = new FileInputStream(properties.getProperty("user.xml.path"));
            // jms
            // close connection
            propertyInputStream.close();
            xmlInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
