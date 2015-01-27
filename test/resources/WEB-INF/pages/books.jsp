<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Books</title>
</head>
<body>
<h1>All books</h1>
<table style="border-style: solid">
    <tr>
        <td>Author</td>
        <td>Book's name</td>
        <td>Year of publication</td>
        <td>Genre</td>
        <td>Actions</td>
    </tr>
    <c:forEach var="book" items="${book}">
        <tr>
        <td>${book.author.getAuthorName()}</td>
        <td>${book.name}</td>
        <td>${book.year}</td>
        <td>${book.genre}</td>
        <td>
            <a href="/updateBook?bookId=${book.bookId}">Edit</a>
            <a href="/deleteBook?bookId=${book.bookId}">Delete</a>
        </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/add-book">New book</a>
</body>
</html>
