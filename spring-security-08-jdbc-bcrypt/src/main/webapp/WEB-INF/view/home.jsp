<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-03-20
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hello from Home :)</h1>

<%--Display username and role--%>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role: <security:authentication property="principal.authorities"/>
</p>
<hr>

<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
    <p><a href="${pageContext.request.contextPath}/leaders">Leaders page(Only for Role: Leader)</a></p>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
    <p><a href="${pageContext.request.contextPath}/systems">Admins page(Only for Role: Admin)</a></p>
</security:authorize>

<p>
    <form:form method="post" action="${pageContext.request.contextPath}/logout">
        <input type="submit" value="Logout"/>
    </form:form>
</p>
</body>
</html>
