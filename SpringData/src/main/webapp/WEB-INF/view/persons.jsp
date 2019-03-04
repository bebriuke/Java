<%-- 
    Document   : index
    Created on : Dec 12, 2018, 2:05:36 PM
    Author     : macbookair
--%>



<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="lt.bit.projektas.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Person DB</title>
    </head>
    <body>
        <h2>List of Persons:</h2>
        <table>
            <% 
                List <Person> l = (List<Person>) request.getAttribute("persons");
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                for (Person p : l) {
                    String birthDateString = (p.getBirthDate() != null) ? birthDateString = sdf.format(p.getBirthDate()) : "";
                    String salaryString = (p.getSalary() != null) ? p.getSalary().toString() : "";
            %> 
            <tr>
               
               
                <td><%=p.getId()%></td>
                <td><%=p.getFirstName()%></td>
                <td><%=p.getLastName()%></td>
                <td><%=birthDateString%></td>
                <td><%=salaryString%></td>
                
                <td><button><a href="persons/edit?id=<%=p.getId()%>">Edit</a></button></td>
                <td><button><a href="persons/delete?id=<%=p.getId()%>">Delete</a></button></td>
                <td><button><a href="address?id=<%=p.getId()%>">Addresses</a></button></td>
                <td><button><a href="contact?id=<%=p.getId()%>">Contacts</a></button></td> 
            </tr>
            <%
               }
            %>
        </table>
        <button> <a href="persons/edit" style="color:palevioletred">Create new</a></button>
   
     
    </body>
</html>
