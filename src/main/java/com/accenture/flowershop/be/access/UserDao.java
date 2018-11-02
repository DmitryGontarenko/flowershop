package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.UserAccount;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDao {

//    public List<UserAccount> users = Arrays.asList(
//            new UserAccount("admin", "admin"),
//            new UserAccount("user", "user"));
//
//    public List<UserAccount> getAllUsers() {
//        return users;
//    }

       private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();

       static {
           initUsers();
       }

       private static void initUsers(){
           UserAccount emp = new UserAccount("admin", "admin");
           UserAccount mng = new UserAccount("user", "user");

           mapUsers.put(emp.getName(), emp);
           mapUsers.put(mng.getName(), mng);
       }

       public static UserAccount findUser(String userName, String password) {
           UserAccount u = mapUsers.get(userName);
           if (u != null && u.getPassword().equals(password)) {
               return u;
           }
           return null;
       }

}
