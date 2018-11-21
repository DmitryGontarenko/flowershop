package com.accenture.flowershop.be.business.exeptions;

public class UserException extends Throwable {

    public static final String USER_UNAUTHORIZED = "Для просмотра требуется авторизация";
    public static final String USER_PERMISSION = "Недостаточно прав для просмотра";

    public UserException(String message) {
        super(message);
    }
}
