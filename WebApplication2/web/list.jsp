<%-- 
    Document   : list
    Created on : Nov 26, 2018, 2:23:31 PM
    Author     : Jurate Valatkevicien
--%>

<%@page import="java.util.List"%>
<%@page import="Duomenys.Person"%>
<%@page import="Duomenys.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
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
        
        
        <h1>Labukas!</h1>
        <% 
            List <Person> list = DB.getAll();
        %>
        
        
        <table>
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
            </tr>
        
        <%
            for(Person p: list){
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
        </tr>
        <%
            }
        %>
        </table>
        
    </body>
</html>
