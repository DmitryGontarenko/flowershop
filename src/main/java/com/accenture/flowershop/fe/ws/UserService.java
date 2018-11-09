package com.accenture.flowershop.fe.ws;

import com.accenture.flowershop.be.entity.user.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User saveUser(User user);
    User login(UserDTO userDTO) throws UserException;
    User register(UserDTO userDTO) throws UserException;
    void setUserSession(HttpSession session, UserDTO userDTO);

    void createUserXmlAndSent(User user);
}
