<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Title</title>


</head>
<body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/js/order.js"></script>

    Корзина:
    Количество: <span class ="cart-quantity">${sessionScope.user.customer.cart.itemCount} </span>
    Цена: <span class="cart-total">${sessionScope.user.customer.cart.total} рублей. </span>
    <a href="/cart">Перейти в корзину</a>

    <div id="mini-cart">

    </div>

    <c:forEach var="product" items="${productlist}">
        <table border="1">
            <tr><h3>${product.name}</h3></tr>
            <tr>
                <td>Цена: ${product.price}</td>
                <td>В наличии: ${product.inStock}</td>
            </tr>
        </table>
        <button class="add-to-cart" role="addCartItem" data-id="${product.id}">Добавить в корзину</button>
    </c:forEach>



</body>
</html>
