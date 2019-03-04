<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="lt.bit.db.Address"%>
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
    
    List <Address> l = p.getAddresses();
            
            
            if(l == null){
                l = new ArrayList();
            }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of person addresses</title>
    </head>
    <body>
        <h1><%=(p.getFirstName() != null) ? p.getFirstName() : "" %>   
            <%=(p.getLastName() != null) ? p.getLastName() : "" %> address list</h1>
        <table>
            <%
                for (Address a : p.getAddresses()) {
            %>
            <tr>
                <td><%=(a.getId()!= null) ? a.getId() : "" %></td>
                <td><%=(a.getAddress() != null) ? a.getAddress() : "" %></td>
                <td><%=(a.getCity() != null) ? a.getCity() : "" %></td>
                <td><%=(a.getPostalCode() != null) ? a.getPostalCode() : "" %></td>
                <td><a href="editAddress.jsp?id=<%=a.getId() %>">Edit</a></td>
                <td><a href="deleteAddress?id=<%=a.getId() %>">Delete</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="editAddress.jsp?personId=<%=p.getId() %>">Create new</a>
        <a href="index.jsp">Back</a><br/>
    </body>
</html>
