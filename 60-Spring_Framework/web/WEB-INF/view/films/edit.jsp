<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<jsp:useBean id="film"
             type="net.sevecek.videoboss.entity.Film"
             scope="request"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>VideoBoss</title>
    <meta charset="UTF-8"/>
    <jstl:url value="/css/style.css" var="cssUrl"/>
    <link rel="stylesheet" type="text/css" href="${cssUrl}"/>
</head>
<body>

    <h1>Film Details and Editing</h1>

    <form action="#" method="post">
        <table>
            <jstl:if test="${film.id ne null}">
                <tr>
                    <th>Number</th>
                    <td>
                        ${film.id}
                    </td>
                </tr>
            </jstl:if>
            <tr>
                <th><label for="name">Name</label></th>
                <td>
                    <input id="name" type="text" name="name"
                           value="<jstl:out value='${film.name}'/>"/>
                </td>
            </tr>
            <tr>
                <th><label for="externalLink">External/External Link</label></th>
                <td>
                    <input id="externalLink" type="text" name="externalLink"
                           value="${film.externalLink}"/>
                </td>
            </tr>
            <tr>
                <th><label for="releaseYear">Release year</label></th>
                <td>
                    <input id="releaseYear" type="text" name="releaseYear" value="${film.releaseYear}"/>
                </td>
            </tr>
            <tr>
                <th><label for="rating">Rating</label></th>
                <td>
                    <input id="rating" type="text" name="rating" value="${film.rating}"/>
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="hidden" name="version" value="${film.version}"/>
                    <input type="submit" name="action" value="Save"/>
                </td>
            </tr>

        </table>
    </form>
</body>
</html>
