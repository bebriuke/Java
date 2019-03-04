<%@page import="lt.bit.db.Person"%>
<%@page import="lt.bit.db.Address"%>
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
    Address a = null;
    if (id != null) {
        a = em.find(Address.class, id);
    }
    Person p = null;
    if (a == null) {
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
        p = a.getPerson();
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
        <title>Address edit</title>
    </head>
    <body>
        <h1><%=(p.getFirstName() != null) ? p.getFirstName() : "" %> <%=(p.getLastName() != null) ? p.getLastName() : "" %> address</h1>
        <form action="editAddress" method="POST">
            <input type="hidden" name="id" value="<%=(a != null) ? a.getId() : "" %>" />
            <input type="hidden" name="personId" value="<%=p.getId() %>" />
            Address: <input type="text" name="address" value="<%=(a != null && a.getAddress() != null) ? a.getAddress() : "" %>" /><br/>
            City: <input type="text" name="city" value="<%=(a != null && a.getCity() != null) ? a.getCity() : "" %>" /><br/>
            Postal code: <input type="text" name="postalCode" value="<%=(a != null && a.getPostalCode() != null) ? a.getPostalCode() : "" %>" /><br/>
            <input type="submit" value="Save" /><br/>
            <a href="addresses.jsp?personId=<%=p.getId() %>">Cancel</a><br/>
        </form>
    </body>
</html>
