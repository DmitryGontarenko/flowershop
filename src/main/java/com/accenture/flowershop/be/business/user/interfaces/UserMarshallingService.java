package com.accenture.flowershop.be.business.user.interfaces;

import com.accenture.flowershop.be.entity.user.User;

import java.io.IOException;

public interface UserMarshallingService {
    void convertFromUserToXML(User user, String filepath) throws IOException;
    User convertFromXMLToUser(String xmlFile) throws IOException;
}
