<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-03-20
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hello from Home :)</h1>
<p>
    <form:form method="post" action="${pageContext.request.contextPath}/logout" >
        <input type="submit" value="Logout" />
    </form:form>
</p>
</body>
</html>
