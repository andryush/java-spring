<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-02-13
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers List</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Add customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button">
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-Mail</th>
                <th>Action</th>
            </tr>

            <c:forEach var="customers" items="${customers}">


                <c:url var="updateLink" value="/customer/showFormForUpdate" >
                    <c:param name="customerId" value="${customers.id}" />
                </c:url>

                <c:url var="deleteLink" value="/customer/deleteCustomer" >
                    <c:param name="customerId" value="${customers.id}" />
                </c:url>

                <tr>
                    <td>${customers.firstName}</td>
                    <td>${customers.lastName}</td>
                    <td>${customers.eMail}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="return confirm('Are you sure you want to delete ${customers.firstName} ${customers.lastName} customer?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
