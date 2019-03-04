<%@page import="lt.bit.db.Person"%>
<%@page import="lt.bit.db.Contact"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String idString = request.getParameter("id");
    Integer id = null;
    try {
        id = new Integer(idString);
    } catch (Exception ex) {
    }
    EntityManager em  = (EntityManager) request.getAttribute("em");
    Contact c = null;
    if (id != null) {
        c = em.find(Contact.class, id);
    }
    Person p = null;
    if (c == null) {
        String personIdString = request.getParameter("personId");
        Integer personId = null;
        try {
            personId = new Integer(personIdString);
        } catch (Exception ex) {
        }
        if (personId != null) {
            p = em.find(Person.class, personId);
        }
    } else {
        p = c.getPerson();
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
        <title>Contact edit</title>
    </head>
    <body>
        <h1><%=(p.getFirstName() != null) ? p.getFirstName() : "" %> <%=(p.getLastName() != null) ? p.getLastName() : "" %> contact</h1>
        <form action="editContact" method="POST">
            <input type="hidden" name="id" value="<%=(c != null) ? c.getId() : "" %>" />
            <input type="hidden" name="personId" value="<%=p.getId() %>" />
            Type: <input type="text" name="type" value="<%=(c != null && c.getType() != null) ? c.getType() : "" %>" /><br/>
            Contact: <input type="text" name="contact" value="<%=(c != null && c.getContact() != null) ? c.getContact() : "" %>" /><br/>
            <input type="submit" value="Save" /><br/>
            <a href="contacts.jsp?personId=<%=p.getId() %>">Cancel</a><br/>
        </form>
    </body>
</html>
