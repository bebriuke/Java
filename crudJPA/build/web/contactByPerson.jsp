<%@page import="lt.bit.db.Contacts"%>
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

            List<Contacts> conList = p.getConList();
            if (conList == null) {
                conList = new ArrayList<>();
            }
        %>
        <table>
            <tr>
                <th><%=p.getId()%></th>
                <th><%=p.getFirstName()%></th>
                <th><%=p.getLastName()%></th>
            </tr>
            </table>
            <%for (Contacts con : conList) {%>
            <tr>

                <td><%=con.getId() != null ? con.getId() : ""%></td>  
                <td><%=con.getType() != null ? con.getType() : ""%></td>  
                <td><%=con.getContact() != null ? con.getContact() : ""%></td>  

            </tr>
 
            <tr>
                <td><a href="editContacts.jsp?id=<%=con.getId()%>">Edit</a></td>
                <td><a href="delCon?id=<%=con.getId()%>">Delete</a></td>
            </tr>
            <br>
            <%}%>
            <tr>
            <a href="editContacts.jsp?pId=<%=p.getId()%>">Create new</a>
            <a href="index.jsp">Back</a>
        </tr> 
        
   
    <%
        EMF.returnEntityManager(em);
    %>
</body>
</html>
