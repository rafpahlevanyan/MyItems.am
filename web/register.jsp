<%@ page import="java.util.List" %>
<%@ page import="myItems.model.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.02.2022
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>


<div style="width: 700px">
    <p>Register</p>
    <form action="/register" method="post">
        <input type="text" name="name" placeholder="name"><br>
        <input type="text" name="surname" placeholder="surname"><br>
        <input type="email" name="email" placeholder="email"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="Register"><br>
    </form>
</div>


</body>
</html>
