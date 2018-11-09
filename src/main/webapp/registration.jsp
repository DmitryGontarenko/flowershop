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
            <input id="reg_username" type="text" name="reg_username">
            <input id="reg_password" type="password" name="reg_password">
            <button type="submit" name="submit">Registration</button>
        </form>

        <%--Сообщение об ошибки--%>
        <p style="color: red;">${errorString}</p>

    </body>
</html>
