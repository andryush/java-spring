<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-02-27
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form for update customers</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>
<form:form method="post" modelAttribute="customers" action="saveCustomers" >
    <form:hidden path="id" />
    <table>
        <caption>CRM - Customer Relationship Management</caption>
            <thead>
                <tr>
                    <td scope="col">First name</td>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td scope="col">Last name</td>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                    <td scope="col">EMail</td>
                    <td><form:input path="eMail" /></td>
                </tr>
                <tr>
                    <td scope="col">Phone number</td>
                    <td><form:input path="phoneNumber" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="save"></td>
                </tr>
            </thead>
    </table>
    <div>
        <a href="${pageContext.request.contextPath}/customers/list">Back to list</a>
    </div>
</form:form>
</body>
</html>
