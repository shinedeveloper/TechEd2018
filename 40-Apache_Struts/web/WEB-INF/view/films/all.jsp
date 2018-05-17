<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="net.sevecek.videoboss.entity.*" %>
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
    <link rel="stylesheet" type="text/css"
          href="${cssUrl}"/>
</head>
<body>
    <h1>List of Films</h1>

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
                    <a href="${film.externalLink}">
                        ${film.name}
                    </a>
                </td>
                <td>${film.releaseYear}</td>
                <td>${film.rating}</td>
                <td>
                    <jstl:url var="filmEditUrl" value="/films/edit.html">
                        <jstl:param name="id" value="${film.id}"/>
                    </jstl:url>
                    <a href="${filmEditUrl}">Edit</a>
                </td>
            </tr>
        </jstl:forEach>
    </table>
    </body>
</html>
