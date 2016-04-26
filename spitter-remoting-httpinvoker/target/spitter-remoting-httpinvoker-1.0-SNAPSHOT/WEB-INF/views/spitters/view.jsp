<%--
  Created by IntelliJ IDEA.
  User: vonzhou
  Date: 16/4/20
  Time: 下午7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Spitter Personal Page</h2>

<c:out value="${spitter.username}"/>
</body>
</html>
