<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar">
    <div class="user-info">
        <c:choose>
            <c:when test="${sessionScope.user.username == null}">
                <div class="userInfo">
                    Welcome guest
                </div>
            </c:when>
            <c:otherwise>
                <div class="userInfo">
                    Welcome ${sessionScope.user.username} <br>
                </div>
            </c:otherwise>
        </c:choose>
        <div class="menu">
            <c:choose>
                <c:when test="${sessionScope.user.username == null}">
                    <div class="menuItem"><a href="/login">Login</a></div>
                </c:when>
                <c:otherwise>
                    <div class="menuItem"><a href="/logout">Logout</a></div>
                </c:otherwise>
            </c:choose>
            <div class="menuItem"><a href="/catalog">Catalog</a></div>
            <div class="menuItem"><a href="/cart">Cart</a></div>
            <div class="menuItem"><a href="/order">Order</a></div>
        </div>
    </div>
    <div class="cart-info">
        <%--КОРЗИНА--%>
        <c:if test="${sessionScope.user.customer.cart != null}">
            <div class="userCount">
                Ваш баланс: ${sessionScope.user.customer.balance} рублей. <br>
                Ваша скидка: ${sessionScope.user.customer.discount}% <br>
            </div>
            <div class="cart">
                <div><b>Корзина:</b> &nbsp;</div>
                <div>Количество: <span class ="cart-quantity">${sessionScope.user.customer.cart.itemCount}</span>&nbsp;</div>
                <div>Цена: <span class="cart-total">${sessionScope.user.customer.cart.total}</span>&nbsp;</div>
                <div><a href="/cart">Перейти в корзину</a></div>
            </div>
        </c:if>
    </div>
</div>
