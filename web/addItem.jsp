<%@ page import="myItems.manager.CategoryManager" %>
<%@ page import="myItems.model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.02.2022
  Time: 02:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
<div style="width: 350px; float:left;">
    <p>Add Item</p>
    <form action="/addItem" method="post" enctype="multipart/form-data">
        <input type="text" name="title" placeholder="title"><br>
        <input type="text" name="price" placeholder="price"><br>
            <select name="category_id">
                <%
                    CategoryManager categoryManager = new CategoryManager();
                    List<Category> allCategories = categoryManager.getAllCategories();
                %>
                <%for (Category category : allCategories) {%> pti xrges jsp or ejy bacvi lra hmi te inchqan kjoxcnes ed arden qu cankutyunn e gin tas, valyuta tas, inch uzes kras enes jogi

                <option value="<%=category.getId()%>"><%=category.getName()%></option>
                <%}%>
        </select><br>
        <input type="file" name="image"><br>
        <input type="submit" value="Add Item">

    </form>

</div>


</body>
</html>
