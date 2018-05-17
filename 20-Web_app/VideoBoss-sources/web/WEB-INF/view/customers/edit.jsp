<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="net.sevecek.videoboss.entity.Customer" %>
<!doctype html>

<jsp:useBean id="customer"
             type="net.sevecek.videoboss.entity.Customer"
             scope="request"/>
<jsp:useBean id="postbackUrl"
             type="java.lang.String"
             scope="request"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>VideoBoss</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>

    <h1>The customer</h1>

    <form action="<%= postbackUrl %>"
          method="post">
        <table>
            <% if (customer.getId() != null) { %>
            <tr>
                <th>Number</th>
                <td>
                    <%= customer.getId() %>
                    <input type="hidden" name="version" value="<%= customer.getVersion() %>"/>
                    <input type="hidden" name="deleted" value="<%= customer.isDeleted() %>"/>
                </td>
            </tr>
            <% } %>
            <tr>
                <th><label for="firstName">First Name</label></th>
                <td>
                    <input id="firstName"
                           name="firstname"
                           value="<%= customer.getFirstName() %>"/>
                </td>
            </tr>
            <tr>
                <th><label for="lastName">Last Name</label></th>
                <td>
                    <input id="lastName"
                           name="lastname"
                           value="<%= customer.getLastName() %>"/>
                </td>
            </tr>
            <tr>
                <th><label for="address">Address</label></th>
                <td>
                    <input id="address"
                           name="address"
                           value="<%= customer.getAddress() %>"/>
                </td>
            </tr>
            <tr>
                <th>&nbsp;</th>
                <td>
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
