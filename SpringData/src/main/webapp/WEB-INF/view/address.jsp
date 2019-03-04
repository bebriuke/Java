<%-- 
    Document   : address
    Created on : Dec 14, 2018, 5:01:24 PM
    Author     : macbookair
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="lt.bit.springdata.db.Addresses"%>
<%@page import="lt.bit.springdata.db.Persons"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Addresses</title>
    </head>
    <body>
        <% 
            Person p = (Person) request.getAttribute("persons");
            
            %>
        <h2>List of Addresses:%></h2>
        <table>

            <%
                List <Address> al = (List<Address>) request.getAttribute("address");
                for (Address a : al) {
            %>
            <tr>
                <td><%= a.getId()%></td>
                <td><%= a.getAddress()%></td>
                <td><%= a.getCity()%></td>
                <td><%= a.getPostalCode()%></td>
                <td><a href="persons/editAddress?id=<%=a.getId()%>" style="color:palevioletred">Edit Address</a></td>
                <td><a href="persons/deleteAddress?id=<%=a.getId()%>" style="color:violet">Delete Address</a></td>

            </tr>
            <% }%>
        </table>
        <a href="persons" style="color:violet">Back</a>
        <a href="persons/editAddress?personId=<%=p.getId()%>" style="color:palevioletred">Create new Address</a>
       
    </body>
</html>
