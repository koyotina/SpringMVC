<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Authors</title>
</head>
<body>
<p><a href="/logout">logout</a></p>
<h1>All authors</h1>
<table style="border-style: solid">
    <tr>
        <td>Author name</td>
        <td>About</td>
    </tr>

    <c:forEach var="author" items="${author}">
        <tr>
            <td>${author.authorName}</td>
            <td>${author.about}</td>
        </tr>
    </c:forEach>

</table>
<br/>
<a href="/add-author">New author</a>
<a href="/books">Go to books</a>
</body>
</html>
