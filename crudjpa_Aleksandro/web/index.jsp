<%@page import="java.util.List"%>
<%@page import="lt.bit.db.Person"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of persons</title>
    </head>
    <body>
        <table>
            <%
                EntityManager em  = (EntityManager) request.getAttribute("em");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Query q = em.createNamedQuery("Person.findAll");
                List<Person> l = q.getResultList();
                for (Person p : l) {
                    String birthDateString = (p.getBirthDate() != null) ? birthDateString = sdf.format(p.getBirthDate()) : "";
                    String salaryString = (p.getSalary() != null) ? p.getSalary().toString() : "";
            %>
            <tr>
                <td><%=p.getId() %></td>
                <td><%=(p.getFirstName() != null) ? p.getFirstName() : "" %></td>
                <td><%=(p.getLastName() != null) ? p.getLastName() : "" %></td>
                <td><%=birthDateString %></td>
                <td><%=salaryString %></td>
                <td><a href="edit.jsp?id=<%=p.getId() %>">Edit</a></td>
                <td><a href="delete?id=<%=p.getId() %>">Delete</a></td>
                <td><a href="addresses.jsp?personId=<%=p.getId() %>">Addresses</a></td>
                <td><a href="contacts.jsp?personId=<%=p.getId() %>">Contacts</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="edit.jsp">Create new</a>
    </body>
</html>
