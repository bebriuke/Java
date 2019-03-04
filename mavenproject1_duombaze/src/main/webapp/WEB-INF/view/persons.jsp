

<%-- <%@page import="lt.bit.zmones.EMF"%> --%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="lt.bit.db.Person"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>main JSP Page</title>
    </head>
    <body>
        <h1>Java World!</h1>
        <%  EntityManager em = EMF.getEntityManager();
            Query q = em.createQuery("select p from Person p");
            List<Person> l = q.getResultList();


        %>
        <table>


            <%  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                for (Person r : l) {
                    String dateStr = "";
                    try {
                      dateStr=formatter.format(r.getBirthDate());
                    } catch (Exception ex) {}
            %>
            <tr>
                <td><%=r.getId()%></td>
                <td><%=r.getFirstName()%></td>
                <td><%=r.getLastName()%></td>
                <td><%=dateStr %></td>
                <td><%=r.getSalary() == null ? "" : r.getSalary()%></td>

                <td><a href="edit.jsp?id=<%=r.getId()%>">Edit</a></td>
                <td><a href="delete?id=<%=r.getId()%>">Delete</a></td>
                <td><a href="adressByPerson.jsp?id=<%=r.getId()%>">Adressess</a></td>
                <td><a href="contactByPerson.jsp?id=<%=r.getId()%>">Contacts</a></td>

            </tr>

            <%
                }
                EMF.returnEntityManager(em);
            %>
            <td><a href="edit.jsp">New</a></td>
        </table>
    </body>
</html>