<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/js/cart.js"></script>

    <div id="my-cart"></div>

    <h3>Cart</h3>
    <c:forEach var="cartItem" items="${sessionScope.user.customer.cart.itemList}">
        <table border="1">
            <tr>
                <td>Наименование: ${cartItem.product.name}</td>
                <td>Цена: ${cartItem.getCartItemTotal}</td>
                <td>Цена со скидкой: ${cartItem.getCartItemTotalDiscount}</td>
            </tr>
        </table>
    </c:forEach>
    <%--Цена с учетом скидки--%>
        <form method="post" action="cart" id="orderForm">
            <input type="text" id="firstName" value="${sessionScope.user.customer.firstName}" placeholder="Enter your name">
            <input type="text" id="lastName" value="${sessionScope.user.customer.lastName}" placeholder="Enter your last name">
            <input type="text" id="phone" value="${sessionScope.user.customer.phoneNumber}" placeholder="Enter your phone">
            <input type="text" id="city" value="${sessionScope.user.customer.city}" placeholder="Enter your city">
            <input type="text" id="street" value="${sessionScope.user.customer.street}" placeholder="Enter your street">
            <input type="text" id="country" value="${sessionScope.user.customer.country}" placeholder="Enter your country">

            <button type="submit">Confirm</button>

        </form>
</body>
</html>
