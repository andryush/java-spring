<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-01-18
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css" />
    <title>Students Registration form</title>
</head>
<body>
    <div class="container">
        <form:form id="contact" action="processForm" modelAttribute="student">
            <h3 align="center">Form for Students</h3>
            <fieldset>
                <form:input path="firstName" style="text-align: center" placeholder="First name" required="requied" autofocus="autofocus"/>
            </fieldset>
            <fieldset>
                <form:input path="lastName" style="text-align: center" placeholder="Last name" required="required" />
            </fieldset>
            <fieldset>
                <input type="submit" value="Submit" />
            </fieldset>
        </form:form>
    </div>
</body>
</html>
