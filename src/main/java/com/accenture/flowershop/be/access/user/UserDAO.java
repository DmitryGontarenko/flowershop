package com.accenture.flowershop.be.access.user;

import com.accenture.flowershop.be.entity.user.User;

import java.util.List;

public interface UserDAO {

    /**
     * Возвращает полный список объектов User
     * @return Лист User
     */
    List<User> findAll();

    /**
     * Возвращает конкретный экземпляр User, представленный указанным ID
     * @param userId ID Пользователя
     * @return User объект
     */
    User findById(long userId);

    /**
     * Возвращает конкретный экземпляр User, представленный указанным Именем
     * @param username Логин Пользователя
     * @return User
     */
    User findByUsername(String username);

    /**
     * Сохраняет пользователя
     * @param user Объект Пользователя для вставки в репозиторий
     * @return Идентификатор записи в репозитории
     */
    Long save(User user);

    /**
     * Обновляет существующего Пользователя
     * @param user Объект Пользователя
     */
    void update(User user);


}
