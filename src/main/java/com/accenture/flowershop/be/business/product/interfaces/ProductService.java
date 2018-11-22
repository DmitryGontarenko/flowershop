package com.accenture.flowershop.be.business.product.interfaces;

import com.accenture.flowershop.be.entity.product.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Сервис для работы с продуктами(цветами)
 */
public interface ProductService {

    /**
     * Это метод найдет все существующие продукты
     * @return Колекция продуктов
     */
    List<Product> findAllProduct();

    /**
     * Этот метод найдет все продукты которорые содержат в своем имени указаную строку
     * @param productName Название продукта для совпадения по имени
     * @return Колекия продуктов
     */
    List<Product> findProductByName(String productName);

    /**
     * Этот метод найдет все продукты которорые содержат в своем имени
     * указанное наименование товара или его часть
     * @param productName Название продукта для совпадения по имени
     * @return Колекия продуктов
     */
    List<Product> findProductByPartName(String productName);

    /**
     * Этот метод вернет продукт, который соотвествует указаному Id
     * @param productId Id Продукта
     * @return Объект Продукта
     */
    Product getProductById(long productId);

    /**
     * Этот метод изменит количичество продуктов на складе
     * @param productId Id Продукта
     * @param quantity Количество
     */
    void changeProductQuantityInStock(Long productId, int quantity);
}
