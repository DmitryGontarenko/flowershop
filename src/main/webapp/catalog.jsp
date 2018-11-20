 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Title</title>
</head>
<body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/js/new_catalog.js"></script>
    <script src="/webjars/jquery/3.1.1/jquery.min.js"></script>


    
    <%--ВЫВОД СПИСКА ТОВАРОВ--%>
    <div class="CartGoods">
    <c:forEach var="product" items="${productlist}">
        <table  class="tstyle">
            <tr><h3>${product.name}</h3></tr>
            <tr>
                <td>Цена: ${product.price}</td>
                <td>В наличии: ${product.inStock}</td>
            </tr>
        </table>
        <button class="add-to-cart" role="addCartItem" data-id="${product.id}">Добавить в корзину</button>
    </c:forEach>
    </div>

    <%--КОРЗИНА--%>
    <c:if test="${sessionScope.user.customer.cart != null}">
    <div class="cart">
        <div><b>Корзина:</b> &nbsp;</div>
        <div>Количество: <span class ="cart-quantity">${sessionScope.user.customer.cart.itemCount}</span>&nbsp;</div>
        <div>Цена: <span class="cart-total">${sessionScope.user.customer.cart.total}</span>&nbsp;</div>
        <div><a href="/cart">Перейти в корзину</a></div>
    </div>    
    </c:if>

</body>
</html>