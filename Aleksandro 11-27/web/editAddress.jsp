<%-- 
    Document   : editAddress
    Created on : Nov 29, 2018, 12:34:31 PM
    Author     : Jurate Valatkevicien
--%>

<%@page import="java.util.List"%>
<%@page import="lt.bit.data.Address"%>
<%@page import="lt.bit.db.DB"%>
<%@page import="lt.bit.data.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address edit</title>
    </head>
    <body>
        <%
            String idString = request.getParameter("id");
            Integer id = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }
            
            String idStringa = request.getParameter("ida");
            Integer ida = null;
            try {
                ida = new Integer(idStringa);
            } catch (Exception ex) {
            }
            
            Person p = DB.getById(id);
            List <Address> a = p.getAddresses();
        %>
        <form action="EditAddress" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : "" %>" />
            <input type="hidden" name="ida" value="<%=(a != null) ? ida : "" %>" />
            Adresas: <input type="text" name="address" value="<%=(DB.getAddressById(ida) != null) ? DB.getAddressById(ida).getAddress()  : "" %>" /><br/>
            Miestas: <input type="text" name="city" value="<%=(DB.getAddressById(ida) != null) ? DB.getAddressById(ida).getCity()  : "" %>" /><br/>
            Pašto kodas: <input type="text" name="pk" value="<%=(DB.getAddressById(ida) != null) ? DB.getAddressById(ida).getPostalCode()  : "" %>" /><br/>
            
            <input type="submit" value="Save" /><br/>
            <a href="adress.jsp?id=<%=p.getId()%>">Cancel</a><br/>
        </form>
    </body>
</html>
