<%-- 
    Document   : sudetis
    Created on : Jan 8, 2019, 2:04:23 PM
    Author     : macbookair
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View'as</title>
    </head>
    <body>
        <h1>Atliekame sudeti:</h1>
        <%= ((Integer) request.getAttribute("a"))+((Integer) request.getAttribute("b"))%>
        ${a+b}
     <%--  session.getAttribute("");
       request.getSession(); --%> 
                
    </body>
</html>
