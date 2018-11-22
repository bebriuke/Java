<%-- 
    Document   : Testas
    Created on : Nov 22, 2018, 1:38:19 PM
    Author     : Jurate Valatkevicien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% /*tiesiog vykdom*/%>
        <%= 10 + 5 /*įvykdom ir grąžinam reikšmę*/%>

        <%
            String s = "Labutis";
            s += " ";
        %>

        <%= s + "mano saule"%>

        <% for (int i = 0; i < 10; i++) {
        %>
        skaicius: <%= i%>
        ----------------------
        <% }%>



    </body>
</html>
