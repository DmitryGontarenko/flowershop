<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--<c:if test="${sessionScope.user.customer.cart != null}">--%>
        <%--Корзина: &nbsp;--%>
        <%--Количество: ${sessionScope.user.customer.cart.itemCount} &nbsp;--%>
        <%--Цена: ${sessionScope.user.customer.cart.total} &nbsp;--%>
        <%--<a href="/cart">Корзина</a>--%>
    <%--</c:if>--%>

    <%--<form method="get" action="/catalog">--%>
        <%--<input type="text" name="productname" id="productname" value="${productname}" placeholder="Enter flower name">--%>
        <%--<button type="submit">Поиск</button>--%>
    <%--</form>--%>

    <c:forEach var="product" items="${productlist}">
        <table border="1">
            <tr><h3>${product.name}</h3></tr>
            <tr>
                <td>Цена: ${product.price}</td>
                <td>В наличии: ${product.inStock}</td>
            </tr>
        </table>
        <%--<form method="post" action="/catalog">--%>
            <%--<button type="submit">Добавить в корзину</button>--%>
        <%--</form>--%>
    </c:forEach>
</body>
</html>
