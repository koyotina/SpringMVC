<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Form</title>
</head>
<body>

<h1 align="center">
    <b>REGISTRATION FORM</b>
</h1>
    <f:form method="POST" commandName="adduser" action="add-user">

        <table>
            <tr>
                <td>
                    <i>User name:</i>
                </td>
                <td>
                    <f:input path="login"/>
                </td>
            </tr>

            <tr>
                <td>
                    <i>User password</i>
                </td>
                <td>
                    <f:input path="password"/>
                </td>
            </tr>

            <tr>
            <td>
                <i>Role:</i>
            </td>
            <td>
                <f:select name="role" path="role">
                    <c:forEach var="roles" items="${roles}">
                        <f:option value="${roles.id}" path="role">${roles.role}</f:option>
                    </c:forEach>
                </f:select>
            </td>

            <tr>
                <td><input type="submit"/></td>
            </tr>
        </table>
</f:form>
</body>
</html>