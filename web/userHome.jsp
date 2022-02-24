<%@ page import="myItems.manager.CategoryManager" %>
<%@ page import="myItems.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="myItems.model.Item" %>
<%@ page import="myItems.model.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.02.2022
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyItems</title>
</head>
<body>

<%
    List<Item> items = (List<Item>) request.getAttribute("items");
    User user = (User) session.getAttribute("user");

%>
Welcome <%=user.getName()%>
<a href="logout">Logout</a>

<div class="main">

    <div class="header" style="margin-left: 100px;margin-bottom: 10px">
        <a href="/userHome" style="font-size: 25px">
            <span style="color: red">My </span><span style="color: blue;">Ite</span><span
                style="color: orange">ms</span>
        </a>
    </div>

    <div class="logout">

    </div>


    <%
        CategoryManager categoryManager = new CategoryManager();
        List<Category> allCategories = categoryManager.getAllCategories();
//        Item item2 = (Item) session.getAttribute("item");
    %>


    <div class="menu" style="margin-left: 150px;display: inline-block;
    float: left; ">
        <p>Items</p>
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
                <% if (item.getPicUrl()!=null){%>
                <td><img src="/image?path=<%=item.getPicUrl()%>" style="width: 100px"><%}%>
                </td>
            </tr>
            <%}%>
        </table>
    </div>

    <a href="/myItems">My items</a><br>
    <a href="/addItem.jsp">Add Item</a>


</div>


</body>
</html>
