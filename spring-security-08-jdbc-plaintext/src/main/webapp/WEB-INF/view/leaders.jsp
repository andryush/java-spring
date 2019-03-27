<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-03-22
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Leaders page</title>
</head>
<body>
<h3>Welcome to leaders pages</h3>
<hr>
<p>
    User: <security:authentication property="principal.username" />
    Role: <security:authentication property="principal.authorities" />
</p>

<form:form action="${pageContext.request.contextPath}/logout" method="post" >
    <input type="submit" value="Logout" />
</form:form>

<a href="${pageContext.request.contextPath}/">Back to home</a>
</body>
</html>
