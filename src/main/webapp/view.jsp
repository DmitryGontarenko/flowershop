<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="w" tagdir="/WEB-INF/tags" %>

<w:wrapper>
    <h3>Заказ</h3>
    <c:if test="${order.status == 'CREATED'}">
        <form method="POST" action="view">
            <input type="hidden" name="orderId" value="${order.id}">
            <button type="submit">Оплатить</button>
        </form>
    </c:if>
    <table class="tstyle">
        <tr>
            <th>Номер заказа</th>
            <th>Статус</th>
            <th>Дата создания</th>
            <th>Общая сумма</th>
        </tr>
        <tr>
            <td>${order.id}</td>
            <td>${order.status}</td>
            <td>${order.createdAt}</td>
            <td>${order.total}</td>
        </tr>
    </table>

</w:wrapper>
