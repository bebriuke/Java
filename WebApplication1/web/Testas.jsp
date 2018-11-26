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
        <style>
            body{
                background-image:url(http://www.humorous.eu/foto/katinas_08.jpg);
            }
            table, th, td {
                border: 1px solid black;
                text-align: center;
                background-color:white;
            }
            
            th {
                background-color:gray;
            }
        </style>
        
        
        <h1>Hello World!</h1>
        <table style="width:100%; ">
            <tr>
              <th>*</th>
               <% for (int i = 1; i <= 10; i++) {
                %>
              <th>
                    <%= i%>
              </th>
              <% }%>
            </tr>
            
            <% for (int i = 1; i <= 15; i++) {
            %>
            <tr>
                <th>
                      <%= i%>
                </th>
                <% for (int j = 1; j <= 10; j++) {
                %>
                <td>
                      <%= i*j%>
                </td>
                <% }%>
                
            </tr>
             <% }%>
        </table>
        
        <br>
        
        <% /*tiesiog vykdom*/%>
        <%= 10 + 5 /*įvykdom ir grąžinam reikšmę*/%>

        <%
            String s = "Labutis";
            s += " ";
        %>

        <%= s + "mano saule"%> <br>

        <% for (int i = 0; i < 10; i++) {
        %>
        skaicius: <%= i%>
        ----------------------<br>
        <% }%>



    </body>
</html>
