<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-01-21
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css" />
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon-ca31b78daf0dd9a106bbf3c6d87d4ec7.png" />
    <title>Customer form</title>
</head>
<body>
    <div class="container">
        <form:form action="processCustomerForm" modelAttribute="customer" id="contact" >
            <h4 align="center">Form for Customers</h4>

            <fieldset>
            <form:input path="firstName" placeholder="First Name (required)" style="align: center" />
                <form:errors path="firstName" cssClass="error" />
            </fieldset>

            <fieldset>
            <form:input path="lastName" placeholder="Last Name (required)" style="align: center" />
                <form:errors path="lastName" cssClass="error" />
            </fieldset>

            <fieldset>
            <form:input path="numberOfPasses" placeholder="Number of passes" style="align: center"/>
                <form:errors path="numberOfPasses" cssClass="error" />
            </fieldset>

            <fieldset>
            <form:input path="postalCode" placeholder="Postal code" style="align: center" />
                <form:errors path="postalCode" cssClass="error" />
            </fieldset>

            <fieldset>
            <form:input path="courseCode" placeholder="Course code" style="align: center" />
                <form:errors path="courseCode" cssClass="error" />
            </fieldset>

            <fieldset>
                <input type="submit" value="Submit" />
            </fieldset>

        </form:form>
    </div>
</body>
</html>
