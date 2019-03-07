<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-01-18
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon-ca31b78daf0dd9a106bbf3c6d87d4ec7.png" />
    <title>New Student Confirmation</title>
</head>
<body>
<h1>
    Name:    ${newstudent.name}<br>
    Surname: ${newstudent.surname}<br>
    Country: ${newstudent.country}<br>
    Language:${newstudent.favoriteLanguage}<br>
    OS:
    <ul>
        <c:forEach var="temp" items="${newstudent.operatingSystems}">
        <li>${temp}</li>
        </c:forEach>
    </ul>
</h1>
</body>
</html>
