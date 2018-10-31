<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h2>Home Page</h2>
        <c:choose>
            <c:when test="${username == null}">
                <div class="userInfo">
                    Welcome guest
                </div>
            </c:when>
            <c:otherwise>
                <div class="userInfo">
                    Welcome ${username} <br>
                    Your discount is: <br>
                    Your balance is: <br>
                </div>
                <a href="${pageContext.request.servletContext.contextPath}/logout">Logout</a>
            </c:otherwise>
        </c:choose>

    </body>
</html>
