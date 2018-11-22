package com.accenture.flowershop.be.access.product;

import com.accenture.flowershop.be.entity.product.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

public interface ProductDAO {

    /**
     * Возвращает полный список объектов Product
     * @return Лист Product
     */
    List<Product> findAll();

    /**
     * Возвращает конкретный экземпляр Product, представленный указанным ID
     * @param productId ID Продукта
     * @return Product объект
     */
    Product findById(long productId);

    /**
     * Возвращает список объектов Product, которые содержат указанное имя
     * @param name Название Продукта
     * @return Лист Product
     */
    List<Product> findByName(String name);

    /**
     * Возвращает список объектов Product, которые содержат полное имя или его часть
     * @param productName Название Продукта
     * @return Лист Product
     */
    List<Product> findByPartName(String productName);

    /**
     * Возвращает список объектов Product, имеющих определенную цену
     * @param price Название Продукта
     * @return Лист Product
     */
    List<Product> findByPrice(BigDecimal price);

    /**
     * TODO: save
     * @param product Объект Продукта
     * @return Идентификатор записи
     */
    Long save(Product product);

    /**
     * Обновляет существующий Продукт
     * @param product Объект Продукта
     */
    void update(Product product);

}
