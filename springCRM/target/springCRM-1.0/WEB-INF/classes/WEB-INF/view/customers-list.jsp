<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-02-27
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MyCRM</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>
<table>
    <caption>CRM - Customer Relationship Management</caption>
    <thead>
    <tr>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">E-Mail</th>
        <th scope="col">Phone number</th>
        <th scope="col">Action</th>
    </tr>
    </thead>


    <tbody>



    <c:forEach var="customers" items="${customers}">

        <c:url var="updateLink" value="/customers/updateCustomers" >
            <c:param name="customersId" value="${customers.id}" />
        </c:url>

        <tr>
            <td data-label="First name">${customers.firstName}</td>
            <td data-label="Last name">${customers.lastName}</td>
            <td data-label="E-Mail">${customers.eMail}</td>
            <td data-label="Phone number">${customers.phoneNumber}</td>
            <td data-label="Action"><a href="${updateLink}">Update</a></td>
        </tr>

    </c:forEach>

    </tbody>
</table>
</body>
</html>
