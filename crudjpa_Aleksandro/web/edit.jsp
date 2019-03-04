<%@page import="lt.bit.db.Person"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person edit</title>
    </head>
    <body>
        <%
            EntityManager em  = (EntityManager) request.getAttribute("em");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String idString = request.getParameter("id");
            Integer id = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }
            Person p = null;
            if (id != null) {
                p = em.find(Person.class, id);
            }
            String birthDateString = (p != null && p.getBirthDate() != null) ? birthDateString = sdf.format(p.getBirthDate()) : "";
            String salaryString = (p != null && p.getSalary() != null) ? p.getSalary().toString() : "";
        %>
        <form action="edit" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : "" %>" />
            First name: <input type="text" name="firstName" value="<%=(p != null && p.getFirstName() != null) ? p.getFirstName() : "" %>" /><br/>
            Last name: <input type="text" name="lastName" value="<%=(p != null && p.getLastName() != null) ? p.getLastName() : "" %>" /><br/>
            Birth date: <input type="text" name="birthDate" value="<%=birthDateString%>" /><br/>
            Salary: <input type="text" name="salary" value="<%=salaryString%>" /><br/>
            <input type="submit" value="Save" /><br/>
            <a href="index.jsp">Cancel</a><br/>
        </form>
    </body>
</html>
