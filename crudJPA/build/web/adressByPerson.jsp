<%@page import="java.util.ArrayList"%>
<%@page import="lt.bit.db.Address"%>
<%@page import="javax.persistence.Query"%>
<%@page import="lt.bit.zmones.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="lt.bit.db.Person"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            EntityManager em = EMF.getEntityManager();

            String idString = request.getParameter("id");
            Integer id = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }
            Person p = null;
            if (id != null) {
                p = em.find(Person.class, id);
            } else {
                System.out.println("eee ner ble");

            }
            if (p == null) {
                p = new Person();
            }

            List<Address> adrList = p.getAdresai();
            if (adrList == null) {
                adrList = new ArrayList<>();
            }
        %>
        <table>
            <tr>
                <th><%=p.getId()%></th>
                <th><%=p.getFirstName()%></th>
                <th><%=p.getLastName()%></th>
            </tr>
            </table>
            <%for (Address adr : adrList) {%>
            <tr>

                <td><%=adr.getId() != null ? adr.getId() : ""%></td>  
                <td><%=adr.getAddress() != null ? adr.getAddress() : ""%></td>  
                <td><%=adr.getCity() != null ? adr.getCity() : ""%></td>  
                <td><%=adr.getPostalCode() != null ? adr.getPostalCode() : ""%></td>  

            </tr>
 
            <tr>
                <td><a href="editAdress.jsp?id=<%=adr.getId()%>">Edit</a></td>
                <td><a href="delAdr?id=<%=adr.getId()%>">Delete</a></td>
            </tr>
            <br>
            <%}%>
            <tr>
            <a href="editAdress.jsp?pId=<%=p.getId()%>">Create new</a>
            <a href="index.jsp">Back</a>
        </tr> 
        
   
    <%
        EMF.returnEntityManager(em);
    %>
</body>
</html>
