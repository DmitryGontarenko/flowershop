<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <link href="style.css" rel="stylesheet" type="text/css">  
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="order" items="${orders}">
        <table class="tstyle">
            <tr>
                <th>Заказ</th>
                <th>ФИО</th>
                <th>Сумма заказа</th>
                <th>Статус</th>
                <th>Дата создания</th>
                <th>Дата обновления</th>
            </tr>
            <tr>
                <td>${order.id}</td>
                <td>${order.customer.lastName} ${order.customer.firstName}</td>
                <td>${order.total}</td>
                <td>${order.status}</td>
                <td>${order.createdAt}</td>
                <td>${order.updatedAt}</td>
                <td style="width: 250px;">
                    <%--Если заказ оплачен - его можно закрыть--%>
                    <c:if test="${order.status == 'PAID'}">
                        <form method = "post" action="order">
                            <input type="hidden" name="orderId" value="${order.id}">
                            <button type="submit">Закрыть</button>
                        </form>
                    </c:if>
                </td>
            </tr>

        </table>
    </c:forEach>
</body>
</html>