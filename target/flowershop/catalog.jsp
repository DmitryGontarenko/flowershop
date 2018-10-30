<%--
  Created by IntelliJ IDEA.
  User: dmitriy.gontarenko
  Date: 30.10.2018
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Title</title>
    </head>
    <body>
        <form id="Form" action="action" method="POST">
            <input type="text" name="parameter"/>
            <button type="submit">Login</button>

            <c:forEach items="${items}" var="iterator" varStatus="rowStatus">
                <div>
                    <label>${iterator.id}</label><label>${iterator.name1}</label>
                </div>
            </c:forEach>
        </form>
    </body>
</html>
