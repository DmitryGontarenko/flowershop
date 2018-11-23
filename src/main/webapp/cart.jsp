<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="w" tagdir="/WEB-INF/tags" %>

<w:wrapper>
    <h3>Cart</h3>
    <div class="cartgoods">
            <%--КОРЗИНА ПОЛЬЗОВАТЕЛЯ--%>
        <table class="table" id="orderProductsCart" border-collapse="1">
            <thead>
            <tr>
                <th>
                    <button role="removeAllCartItems">Удалить все</button>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cartItem" items="${sessionScope.user.customer.cart.itemList}">
                <tr>
                    <th>Наименование</th>
                    <th>Количество</th>
                    <th>Стоимость</th>
                    <th>Стоимость со скидкой</th>
                </tr>
                <tr class ="cartbutton" data-id = "${cartItem.product.id}">
                    <td class="ciProductName">${cartItem.product.name}</td>
                    <td>
                        <button role="removeCartItem" data-id="${cartItem.product.id}">-</button>
                        <span class="ciQuantity">${cartItem.quantity}</span>
                        <button role="addCartItem" data-id="${cartItem.product.id}">+</button>
                    </td>
                    <td class="ciTotalRub"><del>${cartItem.cartItemTotal}</del></td>
                    <td class="ciTotalDiscount">${cartItem.cartItemTotalDiscount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="user">
            <%--ИНФОРМАЦИЯ О ПОЛЬЗОВАТЕЛЕ--%>
        <form method="post" action="cart" id="orderForm">
            <input type="text" id="firstName" value="${sessionScope.user.customer.firstName}" placeholder="Enter your name">
            <input type="text" id="lastName" value="${sessionScope.user.customer.lastName}" placeholder="Enter your last name">
            <input type="text" id="phone" value="${sessionScope.user.customer.phoneNumber}" placeholder="Enter your phone">
            <input type="text" id="city" value="${sessionScope.user.customer.city}" placeholder="Enter your city">
            <input type="text" id="street" value="${sessionScope.user.customer.street}" placeholder="Enter your street">
            <input type="text" id="country" value="${sessionScope.user.customer.country}" placeholder="Enter your country">

            <button type="submit">Confirm</button>

            <c:if test="${error != null}">
                <div class="my-lg-4 alert alert-danger" role="alert">
                        ${error}
                </div>
            </c:if>

        </form>
    </div>
</w:wrapper>