package com.accenture.flowershop.fe.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ProductStockWebService {

    /**
     * Увеличивает количество всех товаров в магазине
     * @param count Количество для увелечения
     */
    void increaseProductStockSize(@WebParam(name = "count") int count);
}
