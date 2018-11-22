package com.accenture.flowershop.fe.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Web Сервис для работы с продуктами
 */
@WebService
public interface ProductStockWebService {

    /**
     * Увеличивает количество всех товаров в магазине
     * @param count Количество для увелечения
     */
    void increaseProductStockSize(@WebParam(name = "count") int count);
}
