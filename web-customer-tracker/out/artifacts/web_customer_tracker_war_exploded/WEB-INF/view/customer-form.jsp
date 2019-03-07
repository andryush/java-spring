<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-02-23
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save customers</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <form:hidden path="id" />

        <table>
            <tbody>
                <tr>
                    <td><label>First name:</label></td>
                    <td><form:input path="firstName" /></td>
                </tr>

                <tr>
                    <td><label>Last name:</label></td>
                    <td><form:input path="lastName" /></td>
                </tr>

                <tr>
                    <td><label>E-Mail</label></td>
                    <td><form:input path="eMail" /></td>
                </tr>
            
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"/></td>
                </tr>

            </tbody>
        </table>

        <div style="clear; both;">

            <p>
                <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
            </p>

        </div>



    </form:form>

</div>
</body>
</html>
