<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<jsp:useBean id="films"
             type="java.util.List<net.sevecek.videoboss.entity.Film>"
             scope="request"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Films</title>
    <meta charset="UTF-8"/>
    <jstl:url value="/css/style.css" var="cssUrl"/>
    <link rel="stylesheet" type="text/css" href="${cssUrl}"/>
</head>
<body>
    <h1>List of Films</h1>

    <h3>
        <jstl:url var="addUrl" value="/films/add.html"/>
        <a href="${addUrl}">Add new film</a>
    </h3>

    <table>
        <tr>
            <th>Number</th>
            <th>Name (External/External Link)</th>
            <th>Release Year</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>

        <jstl:forEach var="film" items="${films}">
            <tr>
                <td>${film.id}</td>
                <td>
                    <jstl:url var="filmUrl"
                              value="${film.externalLink}"/>
                    <a href="${filmUrl}">
                            <jstl:out value="${film.name}"/>
                    </a>
                </td>
                <td>${film.releaseYear}</td>
                <td>${film.rating}</td>
                <td>
                    <jstl:url var="editUrl" value="/films/${film.id}.html"/>
                    <a href="${editUrl}">Edit</a>
                </td>
            </tr>
        </jstl:forEach>
    </table>
</body>
</html>
