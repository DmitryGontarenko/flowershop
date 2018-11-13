<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        <h2>Home Page</h2>
        <c:choose>
            <c:when test="${sessionScope.user.username == null}">
                <div class="userInfo">
                    Welcome guest
                </div>
            </c:when>
            <c:otherwise>
                <div class="userInfo">
                    Welcome ${sessionScope.user.username} <br>
                    Your balance is ${sessionScope.user.customer.balance} рублей. <br>
                    Your discount is ${sessionScope.user.customer.discount}% <br>
                </div>
                <a href="/logout">Logout</a>
                <a href="/catalog">Catalog</a>
            </c:otherwise>
        </c:choose>

    </body>
</html>
