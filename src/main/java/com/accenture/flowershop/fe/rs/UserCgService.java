package com.accenture.flowershop.fe.rs;

public interface UserCgService {

    /**
     * Проверяет содержится ли пользователь с таким логином в бд или нет
     * @param username Имя пользователя
     * @return true - если пользователь с таким логином уже существует
     */
    boolean checkUserExist(String username);
}
