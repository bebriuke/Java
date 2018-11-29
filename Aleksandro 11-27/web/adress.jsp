<%-- 
    Document   : adress
    Created on : Nov 29, 2018, 12:31:43 PM
    Author     : Jurate Valatkevicien
--%>

<%@page import="lt.bit.data.Address"%>
<%@page import="lt.bit.db.DB"%>
<%@page import="lt.bit.data.Person"%>
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
            Person p = DB.getById(id);
        %>
        
            
        <%=p.getFirstName()%>
        <%=p.getLastName()%>
        <br>   
        <table>    
            <% for (Address a : p.getAddresses()) {%>
                <tr>
                    <td><%=a.getId()%></td>
                    <td><%=a.getAddress()%></td>
                    <td><%=a.getCity()%></td>
                    <td><%=a.getPostalCode()%></td>
                    <td><a href="deleteAddress?id=<%=p.getId()%>&ida=<%=a.getId()%>">Delete</a></td>
                    <td><a href="editAddress.jsp?id=<%=p.getId()%>&ida=<%=a.getId()%>">Edit</a></td>
                </tr>
                    
            <% } %>
            
            
                
        </table>
        <a href="editAddress.jsp?id=<%=p.getId()%>">Create new</a>
        <a href="index.jsp">Back</a>
    </body>
</html>
