<%@page import="lt.bit.db.Contact"%>
<%@page import="lt.bit.db.Person"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String personIdString = request.getParameter("personId");
    Integer personId = null;
    try {
        personId = new Integer(personIdString);
    } catch (Exception ex) {
    }
    EntityManager em  = (EntityManager) request.getAttribute("em");
    Person p = null;
    if (personId != null) {
        p = em.find(Person.class, personId);
    }
    if (p == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of person contacts</title>
    </head>
    <body>
        <h1><%=(p.getFirstName() != null) ? p.getFirstName() : "" %> <%=(p.getLastName() != null) ? p.getLastName() : "" %> address list</h1>
        <table>
            <%
                for (Contact c : p.getContacts()) {
            %>
            <tr>
                <td><%=c.getId() %></td>
                <td><%=(c.getType() != null) ? c.getType() : "" %></td>
                <td><%=(c.getContact() != null) ? c.getContact() : "" %></td>
                <td><a href="editContact.jsp?id=<%=c.getId() %>">Edit</a></td>
                <td><a href="deleteContact?id=<%=c.getId() %>">Delete</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="editContact.jsp?personId=<%=p.getId() %>">Create new</a>
        <a href="index.jsp">Back</a><br/>
    </body>
</html>
