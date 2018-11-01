package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

public class UserDao {

    public List<User> users = Arrays.asList(
            new User("admin", "admin"),
            new User("user", "user"));

    public List<User> getAllUsers() {
        return users;
    }
}
