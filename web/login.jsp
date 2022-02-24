<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.02.2022
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login to MyItems</title>
</head>
<body>

<form action="/login" method="post">
    Email: <input type="email" name="email" placeholder="email" required><br>
    Password: <input type="password" name="password" placeholder="password" required><br>
    <input type="submit" value="Login">
</form>


</body>
</html>
