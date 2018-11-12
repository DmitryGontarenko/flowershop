<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<c:set var="title" scope="request" value="Servlet based Filter Demo"/>

        <form method="post" role="form">
            <div>
                <label for="username">Username: </label>
                <input id="username" type="text" name="username">
            </div>

            <div>
                <label for="username">Password: </label>
                <input id="password" type="password" name="password">
            </div>

            <button type="submit" name="submit">Login</button>
            <a href="/registration">Registration</a>
        </form>

<%--Выводит сообщение об ошибки в случае неверного ввода логина или пароля--%>
        <c:if test="${error != null}">
            <div class = "alert">
                    ${error}
            </div>
        </c:if>

</html>

