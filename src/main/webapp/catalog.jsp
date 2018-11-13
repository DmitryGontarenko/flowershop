<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get" action="/catalog">
        <input type="text" name="productname" id="productname" value="${searchProductName}" placeholder="Enter flower name">
        <button type="submit">Поиск</button>
    </form>

    <c:forEach var="product" items="${productlist}">
        <table border="1">
            <tr><h3>${product.name}</h3></tr>
            <tr>
                <td>Цена: ${product.price}</td>
                <td>В наличии: ${product.inStock}</td>
            </tr>
        </table>
        <button type="submit" data-id="${product.id}">Add to cart</button>
    </c:forEach>
</body>
</html>
