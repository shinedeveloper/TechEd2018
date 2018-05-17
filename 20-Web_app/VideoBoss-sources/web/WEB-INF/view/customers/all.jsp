<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="net.sevecek.videoboss.entity.Customer" %>
<%@page import="java.util.List" %>
<!doctype html>

<jsp:useBean id="customers"
             type="java.util.List<net.sevecek.videoboss.entity.Customer>"
             scope="request"/>
<%
   // List<Customer> customers = (List<Customer>) 
   //                request.getAttribute("customers");
%>             

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>VideoBoss</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>

    <h1>Customers</h1>

    <h3>
        <a href="<%=request.getContextPath()%>/customers/add.html">
            Add a customer
        </a>
    </h3>

    <table>
        <tr>
            <th>Number</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Action</th>
        </tr>

        <% 
        for (Customer customer : customers) { %>
            <tr>
                <td><%= customer.getId() %></td>
                <td><%= customer.getFirstName() %></td>
                <td><%= customer.getLastName() %></td>
                <td><%= customer.getAddress() %></td>
                <td>
                    <a href="<%=request.getContextPath()%>/customers/edit.html?id=<%=customer.getId()%>">
                        Edit
                    </a>
                    &nbsp;
                    <a href="<%=request.getContextPath()%>/customers/delete.html?id=<%=customer.getId()%>&amp;version=<%=customer.getVersion()%>">
                        Delete
                    </a>
                </td>
            </tr>
        <% } %>
    </table>

</body>
</html>
