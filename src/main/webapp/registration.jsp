<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="w" tagdir="/WEB-INF/tags" %>

<w:wrapper>
    <div class="reg">
        <h1>Registration users</h1>
        <script src="js/username.js"></script>

        <form  method="post" role="form" id="registerForm">
            <input id="firstName" type="text" name="firstName" placeholder="Enter your name"/>
            <input id="lastName" type="text" name="lastName" placeholder="Enter your second name"/>
            <input id="username" type="text" name="username" placeholder="Enter your login"/>
            <input id="password" type="password" name="password" placeholder="Enter your password"/>
            <button type="submit">Confirm</button>
        </form>

            <%--Сообщение об ошибки в случае неудачной регистрации--%>
        <c:if test = "${error != null}">
            <div class="alert alert-danger" id="registerErrors" role="alert">
                    ${error}
            </div>
        </c:if>
    </div>
</w:wrapper>