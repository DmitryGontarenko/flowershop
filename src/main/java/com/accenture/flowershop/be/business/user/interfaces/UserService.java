package com.accenture.flowershop.be.business.user.interfaces;

import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import com.accenture.flowershop.be.business.exeptions.UserException;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User saveUser(User user);
    User login(UserDTO userDTO) throws UserException;
    User register(UserDTO userDTO) throws UserException;
    void setUserSession(HttpSession session, UserDTO userDTO);

    void UserXML(User user);

}
