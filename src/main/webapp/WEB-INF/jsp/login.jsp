<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>

<body>
<h1>FIT SECRET CHAT</h1>

<form action="#" th:action="@{/login}" th:object="${data}" method="post">
    <p>login: <input type="text" th:field="*{login}" name="login" /></p>
    <p>token: <input type="text" th:field="*{token}" name="token" /></p>
    <p><input type="submit" value="login" /></p>
</form>

</body>
<footer>
    <a type="image"> <img src="footer.jpg"> </a>
</footer>

</html>