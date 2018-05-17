<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<jsp:useBean id="filmForm"
             type="net.sevecek.videoboss.controller.FilmForm"
             scope="request"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>VideoBoss</title>
    <meta charset="UTF-8"/>
    <jstl:url value="/css/style.css" var="cssUrl"/>
    <link rel="stylesheet" type="text/css"
          href="${cssUrl}"/>
</head>
<body>

    <h1>Film Details and Editing</h1>

    <form action="#" method="post">
        <table>
            <tr>
                <th>Number</th>
                <td>
                    ${filmForm.id}
                </td>
            </tr>
            <tr>
                <th><label for="name">Name</label></th>
                <td><input id="name" type="text" name="name" value="${filmForm.name}"/>
                </td>
            </tr>
            <tr>
                <th><label for="externalLink">External/External Link</label></th>
                <td><input id="externalLink" type="text" name="externalLink" value="http://www.external.cz/film/${filmForm.externalLink}"/>
                </td>
            </tr>
            <tr>
                <th><label for="releaseYear">Release year</label></th>
                <td><input id="releaseYear" type="text" name="releaseYear" value="${filmForm.releaseYear}"/>
                </td>
            </tr>
            <tr>
                <th><label for="rating">Rating</label></th>
                <td><input id="rating" type="text" name="rating" value="${filmForm.rating}"/>
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="hidden" name="version" value="${filmForm.version}"/>
                    <input type="submit" name="action" value="Save"/>
                </td>
            </tr>

        </table>
    </form>
</body>
</html>
