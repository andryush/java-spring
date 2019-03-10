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
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form-styles.css"/>

</head>
<body>

    <div class="bootstrap-iso">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="formden_header">
                        <h2>Update customer</h2>
                        <p>Form for update customer's information</p>
                        <form:form method="post" modelAttribute="customers" action="saveCustomers" >
                            <form:hidden path="id" />
                            <div class="form-group">
                                <label for="firstName" class="control-label">First name</label>
                                <form:input path="firstName" cssClass="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="lastName" class="control-label">Last name</label>
                                <form:input path="lastName" cssClass="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="eMail" class="control-label">E-Mail</label>
                                <form:input path="eMail" cssClass="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="phoneNumber" class="control-label">Phone number</label>
                                <form:input path="phoneNumber" cssClass="form-control" />
                            </div>
                            <div class="form-group">
                                <div>
                                    <button type="submit" class="btn btn-primary" name="submit">Save customer</button>
                                    <button type="button" class="btn btn-primary" name="Cancel" onclick="window.location.href='list'; return false;">Cancel</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
