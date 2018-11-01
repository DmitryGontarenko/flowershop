<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
    <head>
        <title>Registration</title>
    </head>
    <body>

            <form method="post" role="form">
                <div class="form-group">
                    <label for="username">Username: </label>
                    <input class="form-control" id="username" type="text" name="username">
                </div>

                <div class="form-group">
                    <label for="username">Password: </label>
                    <input id="password" class="form-control" type="password" name="password">
                </div>

                <button type="submit" name="submit" class="btn btn-info">Registration</button>
            </form>

    </body>
</html>
