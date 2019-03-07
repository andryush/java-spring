<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-01-18
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/select-styles.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon-ca31b78daf0dd9a106bbf3c6d87d4ec7.png" />
    <title>New Student Form</title>
</head>
<body>
<div class="container">
<form:form action="processNewForm" modelAttribute="newstudent" id="contact">
    <h4 align="center">Form for NewStudents</h4>

    <fieldset>
        <form:input path="name" placeholder="First Name" style="text-align: center"  autofocus="autofocus" required="required"/>
    </fieldset>

    <fieldset>
        <form:input path="surname" placeholder="Lastname" style="text-align: center" required="required" />
    </fieldset>

    <p align="center">Choose country</p>
    <div class="styled-select semi-square green">
         <form:select path="country">

             <%--KEY-VALUE from java class--%>
             <form:options items="${newstudent.countryOptions}" />


        <%--Manualy add KEY VALUE to select
            <form:option value="Armenia" label="Armenia" />
            <form:option value="United States" label="United States" />
            <form:option value="Jamaica" label="Jamaica" />
            <form:option value="Fiji" label="Fiji" />
        --%>
         </form:select>
    </div>
    <p align="center">Favorite programming language<br>

    <form:radiobutton path="favoriteLanguage" value="Java"/>&nbsp;Java&nbsp;

    <form:radiobutton path="favoriteLanguage" value="C#" />&nbsp;C#&nbsp;

    <form:radiobutton path="favoriteLanguage" value="Python" />&nbsp;Python

    </p>

    <p align="center">Choose operating systems<br>

    <form:checkbox path="operatingSystems" value="Linux" />&nbsp;Linux&nbsp;

    <form:checkbox path="operatingSystems" value="MacOS" />&nbsp;MacOS&nbsp;

    <form:checkbox path="operatingSystems" value="Windows" />&nbsp;Windows


    </p>

    <filedset>
        <input type="submit" value="Submit">
    </filedset>



</form:form>

</div>
</body>
</html>
