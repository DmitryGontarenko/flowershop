package com.accenture.flowershop.be.access.user;

import com.accenture.flowershop.be.entity.user.User;

import java.util.List;

public interface UserDAO {

    // возвращает полный список объектов User
    List<User> findAll();

    // возвращает конкретный экземпляр User по ID
    User findById(long userId);

    // возвращает конкретный экземпляр User по username
    User findByUsername(String username);

    Long save(User user);

    void update(User user);

    void delete(long userId);

}
