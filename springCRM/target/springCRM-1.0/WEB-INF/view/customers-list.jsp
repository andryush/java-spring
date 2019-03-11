<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-02-27
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>MyCRM</title>
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form-styles.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>

<div class="bootstrap-iso" align="center">
    <div class="container-fluid">
        <div class="row">
            <div class="formden_header">
                <h2>CRM - Customer Relationship Management</h2>
                <div class="form-group">
                    <div>
                        <button type="button" class="btn btn-primary" name="Add customer"
                                onclick="window.location.href='showFormForAddingCustomers'; return false;">Add customers
                        </button>
                    </div>
                </div>
                <div class="form-group">
                    <form:form action="searchCustomer" method="get">
                        <input type="text" placeholder="Search for a customer"
                               name="theSearchName" class="form-control" style="text-align: center"/>
                        <button class="btn btn-primary" type="submit" name="search">Search</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<table>
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

        <c:url var="updateLink" value="/customers/updateCustomers">
            <c:param name="customersId" value="${customers.id}"/>
        </c:url>

        <c:url var="deleteLink" value="/customers/deleteCustomers">
            <c:param name="customersId" value="${customers.id}"/>
        </c:url>

        <tr>
            <td data-label="First name">${customers.firstName}</td>
            <td data-label="Last name">${customers.lastName}</td>
            <td data-label="E-Mail">${customers.eMail}</td>
            <td data-label="Phone number">${customers.phoneNumber}</td>
            <td data-label="Action"><a href="${updateLink}">Update</a> | <a href="${deleteLink}"
                                                                            onclick="return confirm('Are you sure you want to delete ${customers.firstName} ${customers.lastName} customer?')">Delete</a>
            </td>
        </tr>

    </c:forEach>

    </tbody>
</table>
</body>
</html>
