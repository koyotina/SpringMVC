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
<h1>New book</h1>
<f:form method="POST" commandName="addbook" action="books">
    <table>
        <tr>
            <td>
                <i>Author:</i>
            </td>
            <td>
                <f:select name="id" path="id">
                    <c:forEach var="author" items="${author}">
                        <f:option value="${author.id}" path="id">${author.authorName}</f:option>
                    </c:forEach>
                </f:select>
            </td>
        </tr>
        <tr>
            <td>
                <i>Book's name:</i>
            </td>
            <td>
                <f:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Year of publication</i>
            </td>
            <td>
                <f:input path="year"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Genre</i>
            </td>
            <td>
                <f:input path="genre"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</f:form>
</body>
</html>
