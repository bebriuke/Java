<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
            DateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
        %>
        <form action="edit" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : "" %>" />
            First name: <input type="text" name="firstName" value="<%=(p != null) ? p.getFirstName() : "" %>" /><br/>
            Last name: <input type="text" name="lastName" value="<%=(p != null) ? p.getLastName() : "" %>" /><br/>
            Date of Birthday: <input type="date" name="birthDate" value="<%=(p != null) && p.getBirthDate() != null ? format.format(p.getBirthDate()) : "" %>" /><br/>
            Salary: <input type="text" name="salary" value="<%=(p != null)&&(p.getSalary() != null) ? p.getSalary().toString() : "" %>" /><br/>
            
            <input type="submit" value="Save" /><br/>
            <a href="index.jsp">Cancel</a><br/>
        </form>
    </body>
</html>
