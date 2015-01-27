<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add book</title>
</head>
<body>
<p><a href="/logout">logout</a></p>
<h1>New author</h1>
<f:form method="POST" commandName="addauthor" action="authors">
    <table>
        <tr>
            <td>
                <i>Author's name:</i>
            </td>
            <td>
                <f:input path="authorName"/>
            </td>
        </tr>

        <tr>
            <td>
                <i>About author</i>
            </td>
            <td>
                <f:input path="about"/>
            </td>
        </tr>

        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</f:form>
</body>
</html>
