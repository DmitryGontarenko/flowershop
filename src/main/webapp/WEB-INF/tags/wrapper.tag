<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="/style/style.css" rel="stylesheet" type="text/css">
        <title>Flowershop</title>

    </head>
    <body>
        <jsp:include page="/header.jsp"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="/js/catalog.js"></script>
        <script src="/webjars/jquery/3.1.1/jquery.min.js"></script>

        <div class="my-md-4 container">
            <jsp:doBody/>
        </div>

    </body>
</html>