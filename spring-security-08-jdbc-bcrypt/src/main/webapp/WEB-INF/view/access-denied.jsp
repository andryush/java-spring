<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-03-22
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
<h1>Access denied. You are not authorized to access this page</h1>
<form:form action="${pageContext.request.contextPath}/logout" method="post" >
    <input type="submit" value="Logout" />
</form:form>

<a href="${pageContext.request.contextPath}/">Back to home</a>
</body>
</html>
