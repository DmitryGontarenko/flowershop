<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Registration users</h1>

        <form method="post" role="form">
            <input id="firstName" type="text" name="firstName" placeholder="Enter your name"/>
            <input id="lastName" type="text" name="lastName" placeholder="Enter your second name"/>
            <input id="username" type="text" name="username" placeholder="Enter your login"/>
            <input id="password" type="password" name="password" placeholder="Enter your password"/>

            <button type="submit" name="submit">Confirm</button>
        </form>

        <%--Сообщение об ошибки в случае неудачной регистрации--%>
        <c:if test = "&{error != null}">
            <div class = "alert">
                ${error}
            </div>
        </c:if>


    </body>
</html>
