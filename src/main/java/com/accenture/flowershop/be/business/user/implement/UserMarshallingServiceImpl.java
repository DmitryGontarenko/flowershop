package com.accenture.flowershop.be.business.user.implement;

import com.accenture.flowershop.be.business.user.interfaces.UserMarshallingService;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service("UserMarshallingService")
public class UserMarshallingServiceImpl implements UserMarshallingService {

    @Autowired
    private Marshaller marshaller;
    @Autowired
    private Unmarshaller unmarshaller;

    @Override
    public void convertFromUserToXML(User user, String filepath) throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(filepath);
            marshaller.marshal(user, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    @Override
    public User convertFromXMLToUser(String xmlFile) throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(xmlFile);
            return (User)unmarshaller.unmarshal(new StreamSource(is));
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
