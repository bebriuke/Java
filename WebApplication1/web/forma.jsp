<%-- 
    Document   : forma
    Created on : Nov 26, 2018, 12:44:59 PM
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
        
        <form action="saveData" method="POST">
            
            First name:<br>
            <input type="text" name="firstName">
            <br>
            Last name:<br>
            <input type="text" name="lastName">
            <br><br>
            <input type="submit" value="Siųsk">

            
            
        </form>
    </body>
</html>
