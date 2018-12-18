<%-- 
    Document   : contact
    Created on : Dec 18, 2018, 12:45:35 PM
    Author     : Jurate Valatkevicien
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="duomenys.Contacts"%>
<%@page import="duomenys.Person"%>
<%@page import="duomenys.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contacts Page</title>
    </head>
    <body>
         <style>
            table, th, td {
                border: 1px solid black;
                text-align: center;
                background-color:white;
            }
            table{
                width: 80%;
            }
            
            th {
                background-color:gray;
            }
        </style>
        
        <%
            String idString = request.getParameter("id");
            Integer id = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }
           
            
            //Query q = em.createQuery("select p from Addresses p");
            EntityManager em = EMF.getEntityManager();
            Person p = null;
            if(id != null){
                
                //EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication3_CRUD_JPAPU");
                p = em.find(Person.class, id);
                //em.close();
                
            }
            
            if (p == null){
                p = new Person();
            }
            
            List <Contacts> l = p.getContacts();
            
            
            if(l == null){
                l = new ArrayList();
            }
            
            
            
        %>
        
            
        <%=p.getFirstName()%>
        <%=p.getLastName()%>
        <br>   
        <table>    
            <% for (Contacts a : l) {%>
                <tr>
                    <td><%=a.getId() != null ? a.getId(): ""%></td>
                    <td><%=a.getId() != null ? a.getType(): ""%></td>
                    <td><%=a.getId() != null ? a.getAddres(): ""%></td>
                    <td><a href="deleteContact?id=<%=p.getId()%>&ida=<%=a.getId()%>">Delete</a></td>
                    <td><a href="editContact.jsp?id=<%=p.getId()%>&ida=<%=a.getId()%>">Edit</a></td>
                </tr>
                    
            <% } %>
            
            
                
        </table>
        <a href="editContact.jsp?id=<%=p.getId()%>">Create new</a>
        <a href="index.jsp">Back</a>
        
        <%
            EMF.returnEntityManager(em);  //emf.close();
        %>
    </body>
</html>
