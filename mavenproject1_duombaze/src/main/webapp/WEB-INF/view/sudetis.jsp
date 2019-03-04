<%-- 
    Document   : sudetis
    Created on : Jan 8, 2019, 2:05:36 PM
    Author     : Jurate Valatkevicien
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <!-- jstl naudojasmas jsp puslapiuose --> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sudėtis</title>
    </head>
    <body>
        ${a+b} <!--  identiška 18 eilutei --> 
        <h1>Sudėtis</h1>
        <%= ((Integer) request.getAttribute("a")) + ((Integer) request.getAttribute("b")) %> <!-- standartinė jsp sintaksė --> 
        <% session.getAttribute("");  //
           request.getSession(); //grąžina session objektą, sesiją, jeigu ji jau buvo, jeigu nebuvo, tai sukuria; tas pats su true
           //request.getSession(false); // jeigu nėra, tai nekurk
           Integer id=0;
           session.setAttribute("krepselioID", id);
           session.getAttribute("krepselio ID");
           session.invalidate(); // išsilogina
        %>
                   
                
    </body>
</html>
