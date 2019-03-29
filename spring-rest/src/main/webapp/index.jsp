<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-03-28
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring REST</title>
</head>
<body>
<h3>Spring REST</h3>
<hr>
<a href="${pageContext.request.contextPath}/test/hello">Hello REST</a>
<br>
<a href="${pageContext.request.contextPath}/api/students">Students REST</a>
</body>
</html>
