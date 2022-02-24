<%@ page import="myItems.model.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="myItems.model.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.02.2022
  Time: 01:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Items</title>
</head>
<body>

<%
    List<Item> items = (List<Item>) request.getAttribute("items");
    User user = (User) session.getAttribute("user");
%>
<div class="header" style="margin-left: 100px;margin-bottom: 10px">
    <a href="/userHome" style="font-size: 25px">
        <span style="color: red">My </span><span style="color: blue;">Ite</span><span
            style="color: orange">ms</span>
    </a>
</div>

    <p>My Items</p>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Price</th>
            <th>Image</th>
        </tr>

        <%
            for (Item item : items) {%>
        <tr>
            <td><%=item.getTitle()%>
            </td>
            <td><%=item.getPrice()%>
            </td>
            <td><%=item.getPicUrl()%>
            </td>
        </tr>
        <%}%>
    </table>



</body>
</html>
