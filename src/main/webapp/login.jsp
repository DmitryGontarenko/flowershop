<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<c:set var="title" scope="request" value="Servlet based Filter Demo"/>
<%--<c:choose>--%>
    <%--<c:when test="${username == null}">--%>
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
            <a href="${pageContext.request.contextPath}/registration">Registration</a>
        </form>

        <%--Сообщение об ошибки--%>
        <p style="color: red;">${errorString}</p>

        <c:if test="${error != null}">
            <div class="my-lg-4 alert alert-danger" role="alert">
                    ${error}
            </div>
        </c:if>

<%--</c:when>--%>
    <%--<c:otherwise>--%>
        <%--<div class="alert alert-success" tole="alert">--%>
            <%--<strong>You are signed in ${username}</strong>--%>
        <%--</div>--%>
        <%--<a href="${pageContext.request.servletContext.contextPath}/logout">Logout</a>--%>
    <%--</c:otherwise>--%>
<%--</c:choose>--%>
</html>

