<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="lt.bit.data.Person"%>
<%@page import="lt.bit.db.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of persons</title>
    </head>
    <body>
        <% DateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); %>
        <table>
            <%
                for (Person p : DB.getAll()) {
            %>
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getFirstName()%></td>
                <td><%=p.getLastName()%></td>
                <td><%=format.format(p.getBirthDate())%></td>
                <td><a href="edit.jsp?id=<%=p.getId()%>">Edit</a></td>
                <td><a href="delete?id=<%=p.getId()%>">Delete</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="edit.jsp">Create new</a>
    </body>
</html>
