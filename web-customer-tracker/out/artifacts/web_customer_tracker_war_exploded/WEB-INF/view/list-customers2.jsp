<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-02-14
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CRM2</title>
</head>
<body>
<h2>Customers list 2</h2>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>E-mail</th>
            </tr>
            <c:forEach var="tempCustomers" items="${customersAtr}">
                <tr>
                    <td>${tempCustomers.firstName}</td>
                    <td>${tempCustomers.lastName}</td>
                    <td>${tempCustomers.eMail}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
