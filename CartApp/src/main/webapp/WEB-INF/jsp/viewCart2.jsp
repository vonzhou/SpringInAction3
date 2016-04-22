<%--
  Created by IntelliJ IDEA.
  User: vonzhou
  Date: 16/4/21
  Time: 下午4:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>View Cart</h1>

<h2>Items in Your Cart</h2>

<a href="${flowExecutionUrl}&_eventId=submit">Submit</a>

<h2>Products for Your Choice</h2>
<table>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.description}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
