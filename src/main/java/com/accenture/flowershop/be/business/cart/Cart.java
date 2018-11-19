package com.accenture.flowershop.be.business.cart;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

/**
 * Корзина для товаров
 * items - Коллекция предметов в корзине
 * total - Обшая стоимость корзины
 * discount - Скидка
 * itemCount Количество товаров в корзине
 */

public class Cart {

    private Map<Long, CartItem> items;
    private BigDecimal total;
    private int discount;
    private int itemCount;

    public Cart() {
        itemCount = 0;
        discount = 0;
        items = new HashMap<>();
        total = new BigDecimal(0);
    }

    public Cart(int discount) {
        this(); // call default constructor
        this.discount = discount;
    }

    /**
     * Метод пересчитывает общее количество продуктов в корзине
     */
    public void calculateCountItems() {
        int count = 0;
        for (CartItem cartItem : items.values()) {
            int quantity = cartItem.getQuantity();
            count += quantity;
        }
        this.itemCount = count;
    }

    /**
     * Метод пересчитываем обшую стоимость товаров в корзине
     */
    public void calculateTotalCost() {
        BigDecimal result = BigDecimal.ZERO;

        // проходим циклом по всем предметам в корзине
        for(CartItem cartItem : items.values()) {
            // получаем стоимость каждого предмета
            BigDecimal price = cartItem.getProduct().getPrice();
            // получем поличество предметов
            int quantity = cartItem.getQuantity();
            // умножаем стоимость товаров на их количество
            BigDecimal priceQuantity = price.multiply(new BigDecimal(quantity));
            result = result.add(priceQuantity);
        }
        // Если присутствует скидка, то формируем общую стоимость с учетом скидки,
        if(discount != 0) {
            // Получем сумму скидку: общая стоимость discountPrice = result * discount / 100
            BigDecimal discountPrice = result.multiply(new BigDecimal(discount).divide(new BigDecimal(100)));
            // Получаем конечную сумму: result - discountPrice
            this.total = result.subtract(discountPrice);
            // если скидки нет, возвращаем цену без скидки
        } else {
            this.total = result;
        }
    }

    /**
     * Метод добавляем новый предмет/товар в корзину
     * @param newItem новый предмет для добавления в корзину
     */
    public void addItem(CartItem newItem) {
        // если предмет содержится в корзине, то увеличиваем его количетсов
        if(items.containsKey(newItem.getProduct().getId())) {
            CartItem item = items.get(newItem.getProduct().getId());
        // иначе добавляем новый элемент в корзину
        } else {
            items.put(newItem.getProduct().getId(), newItem);
            newItem.setDiscount(discount);
        }
        // подсчитываем количество товаров после изменений в корзине
        calculateCountItems();
        // подсчитываем общую стоимость после изменений
        calculateTotalCost();
    }

    public void removeItem(CartItem cartItem) {
        // TODO: realise method
    }

    public void removeAllItem() {
        // TODO: realise method
    }

    public Map<Long, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Long, CartItem> items) {
        this.items = items;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<CartItem> getItemList() {
        return new ArrayList<CartItem>(items.values());
    }
}
