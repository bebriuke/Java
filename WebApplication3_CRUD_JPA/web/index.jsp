<%-- 
    Document   : index.jsp
    Created on : Dec 12, 2018, 2:05:58 PM
    Author     : Jurate Valatkevicien
--%>

<%@page import="duomenys.EMF"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="duomenys.Person"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person list</title>
              <style>
            table, th, td {
                border: 1px solid black;
                text-align: center;
                background-color:white;
            }
            table{
                width: 40%;
            }
            
            th {
                background-color:gray;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            EntityManager em = EMF.getEntityManager();
            Query q = em.createQuery("select p from Person p");
            List<Person> l = q.getResultList();
            
            
            //em.close();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
        %>
      <%= //p.toString() 
          l.toString()
      
      %>
               
        <h1>Graži lentelė!</h1>      
        
        <table>
            <%
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                for (Person r : l) {
                    String dateStr = "";
                    try {
                      dateStr=formatter.format(r.getBirthDate());
                    } catch (Exception ex) {}
                }
            %>
            
            <tr>
                <th>
                     id
                </th>
                <th>
                    firstName
                </th>
                <th>
                    lastName
                </th>
                <th>
                    birthDate
                </th>
                <th>
                    salary
                </th>
            </tr>
        
        <%
            for(Person p: l){
        %>
        <tr>
            <td> <%=p.getId()
        %>
            </td>
            <td> <%=p.getFirstName()
        %>
            </td>
            <td> <%=p.getLastName()
        %>
            </td>
            <td> <%=dateFormat.format(p.getBirthDate())
        %>
        
            </td>
            <td> <%=p.getSalary()
        %>
            </td>
            <td><a href="edit.jsp?id=<%=p.getId()%>">Edit</a></td>
            <td><a href="delete?id=<%=p.getId()%>">Delete</a></td>
            <td><a href="adress.jsp?id=<%=p.getId()%>">Adresai</a></td>
            <td><a href="contact.jsp?id=<%=p.getId()%>">Kontaktai</a></td>
        </tr>
        <%
            }
        %>
        </table>
      <a href="edit.jsp">Create new</a>
        
        
      <%
          EMF.returnEntityManager(em); //emf.close();
      %>
    </body>
</html>
