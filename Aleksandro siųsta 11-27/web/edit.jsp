<%@page import="lt.bit.db.DB"%>
<%@page import="lt.bit.data.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person edit</title>
    </head>
    <body>
        <%
            String idString = request.getParameter("id");
            Integer id = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }
            Person p = DB.getById(id);
        %>
        <form action="edit" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : "" %>" />
            First name: <input type="text" name="firstName" value="<%=(p != null) ? p.getFirstName() : "" %>" /><br/>
            Last name: <input type="text" name="lastName" value="<%=(p != null) ? p.getLastName() : "" %>" /><br/>
            <input type="submit" value="Save" /><br/>
            <a href="index.jsp">Cancel</a><br/>
        </form>
    </body>
</html>
