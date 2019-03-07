<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-01-18
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css" />
    <title>Hello World - Input Form</title>
</head>
<body>

<div class="container">
    <form id="contact" action="processForm2" method="get">
        <h3 align="center">Form using SpringMVC</h3>
        <fieldset>
            <input placeholder="Your name" style="text-align: center" type="text" tabindex="1" name="studentName" required autofocus>
        </fieldset>
        <fieldset>
            <input placeholder="Your lastname" style="text-align: center" type="text" tabindex="2" name="studentLastName" required>
        </fieldset>
        <fieldset>
            <input id="contact-input" type="submit" value="Submit">
        </fieldset>

    </form>
</div>

</body>
</html>

