<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 2019-01-21
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Confirmation Page</title>
</head>
<body>
The customer has been confirmed<br />
Name:        ${customer.firstName}<br />
Last name:   ${customer.lastName}<br />
Free passes: ${customer.numberOfPasses}<br />
Postal code: ${customer.postalCode}<br />
Course code: ${customer.courseCode}
</body>
</html>
