<%-- 
    Document   : adress
    Created on : Nov 29, 2018, 12:31:43 PM
    Author     : Jurate Valatkevicien
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="duomenys.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="duomenys.Address"%>
<%@page import="duomenys.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Page</title>
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
            
            List <Address> l = p.getAddresses();
            
            
            if(l == null){
                l = new ArrayList();
            }
            
            
            
        %>
        
            
        <%=p.getFirstName()%>
        <%=p.getLastName()%>
        <br>   
        <table>    
            <% for (Address a : l) {%>
                <tr>
                    <td><%=a.getId() != null ? a.getId(): ""%></td>
                    <td><%=a.getId() != null ? a.getAddress() : ""%></td>
                    <td><%=a.getId() != null ? a.getCity() : ""%></td>
                    <td><%=a.getId() != null ? a.getPostalCode() : ""%></td>
                    <td><a href="deleteAddress?id=<%=p.getId()%>&ida=<%=a.getId()%>">Delete</a></td>
                    <td><a href="editAddress.jsp?id=<%=p.getId()%>&ida=<%=a.getId()%>">Edit</a></td>
                </tr>
                    
            <% } %>
            
            
                
        </table>
        <a href="editAddress.jsp?id=<%=p.getId()%>">Create new</a>
        <a href="index.jsp">Back</a>
        
        <%
            EMF.returnEntityManager(em);  //emf.close();
        %>
        
    </body>
</html>
