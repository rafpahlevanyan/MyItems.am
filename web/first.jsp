<%@ page import="java.util.List" %>
<%@ page import="myItems.model.Item" %>
<%@ page import="myItems.manager.CategoryManager" %>
<%@ page import="myItems.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.02.2022
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyItems</title>
</head>

<style>
    * {
        margin: 0;
        padding: 0;
    }
</style>
<body>

<%
    List<Item> items = (List<Item>) request.getAttribute("items");
%>
<div class="main">

    <div class="header" style="margin-left: 100px;margin-bottom: 10px">
        <a href="/" style="font-size: 25px">
        <span style="color: red">My </span><span style="color: blue;">Ite</span><span
            style="color: orange">ms</span>
        </a>
    </div>
    <div>
        <%
            CategoryManager categoryManager = new CategoryManager();
            List<Category> allCategories = categoryManager.getAllCategories();
        %>
        <form action="/showItems">
            <select name="catId">
                    <%for (Category category : allCategories) {%>
                <option value="<%=category.getId()%>"><%=category.getName()%></option>
                    <%}%>

                <input type="submit" value="Search">
        </form>
    </div>

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
                <td><% if (item.getPicUrl()!=null){%>
                <td><img src="/image?path=<%=item.getPicUrl()%>" style="width: 100px"><%}%>
                </td>

            </tr>
            <%}%>
        </table>
    </div>


<div class="log" style="padding-left: 200px">
    <div class="login">
        <a href="/login.jsp" style="border: 1px solid">Login</a>
    </div>
    <div class="register">
        <a href="/register.jsp">Register</a>
    </div>
</div>

</div>
</body>
</html>