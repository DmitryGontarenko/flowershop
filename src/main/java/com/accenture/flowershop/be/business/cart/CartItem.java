package com.accenture.flowershop.be.business.cart;

import com.accenture.flowershop.fe.dto.product.ProductDTO;

import java.math.BigDecimal;

/**
 * Предметы в корзине
 * product - продукты/товары в корзине
 * quantity - количество продуктов/товаров
 * discount - скидка
 */

public class CartItem {

    private ProductDTO product;
    private int quantity;
    private int discount;

    public CartItem(ProductDTO product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Возвращает общую стоимость предметов корзины
     * multiply - умножить
     * @return Общая стоимость
     */
    public BigDecimal getCartItemTotal() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }

    /**
     * Возвращает общую стоимость предметов корзины с учетом скидки
     * @return Общая стоимость с учетом скидки
     */
    public BigDecimal getCartItemTotalDiscount() {
        // cartItemTotal = цена корзины без скидки
        BigDecimal cartItemTotal = getCartItemTotal();
        // если скидка не равно нулю
        if (discount != 0) {
            BigDecimal discountTotal = cartItemTotal.multiply(new BigDecimal(discount)).divide(new BigDecimal(100));
            cartItemTotal = cartItemTotal.subtract(discountTotal);
        }
        return cartItemTotal;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
