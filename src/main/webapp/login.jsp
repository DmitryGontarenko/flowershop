<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<c:set var="title" scope="request" value="Servlet based Filter Demo"/>
<c:choose>
    <c:when test="${username == null}">
        <form method="post" role="form">
            <div class="form-group">
                <label for="username">Username: </label>
                <input class="form-control" id="username" type="text" name="username">
            </div>

            <div class="form-group">
                <label for="username">Password: </label>
                <input id="password" class="form-control" type="password" name="password">
            </div>

            <button type="submit" name="submit" class="btn btn-info">Login</button>
        </form>
    </c:when>
    <c:otherwise>
        <div class="alert alert-success" tole="alert">
            <strong>You are signed in ${username}</strong>
        </div>
        <a href="${pageContext.request.servletContext.contextPath}/logout">Logout</a>
    </c:otherwise>
</c:choose>
</html>

