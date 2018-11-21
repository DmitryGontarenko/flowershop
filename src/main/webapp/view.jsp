<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <h3>Зкаказ</h3>
    <c:if test="${order.status == 'CREATED'}">
        <form method="POST" action="view">
            <input type="hidden" name="orderId" value="${order.id}">
            <button type="submit">Оплатить</button>
        </form>
    </c:if>
    ${order.id}
    ${order.status}
    ${order.createdAt}
    ${order.total}

    <c:forEach var="orderProduct" items="${order.orderProductDTOList}">
        ${orderProductDTOList.product.name}
        ${orderProductDTOList.quantity}
    </c:forEach>
    </body>
</html>
