<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-03-21
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>
<h3>Custom login page</h3>
<form:form method="post" action="${pageContext.request.contextPath}/authenticateUser">

    <%--Check for login error--%>
    <c:if test="${param.error != null}">
        <i class="failed">Sorry! You entered invalid username or password.</i>
    </c:if>

    <p>
        Username:<input name="username" type="text" />
    </p>
    <p>
        Password:<input name="password" type="password" />
    </p>
    <input type="submit" value="Login"/>
</form:form>
</body>
</html>
