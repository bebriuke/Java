<%@page import="lt.bit.zmones.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="lt.bit.db.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person edit</title>
    </head>
    <body>
        <%
            EntityManager em = EMF.getEntityManager();

            String idString = request.getParameter("id");
            Integer id = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }
            Person p=null;
            try {
                p = em.find(Person.class, id);
            } catch (Exception ex) {
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        %>
        <form action="edit" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : ""%>" />
            First name: <input type="text" name="firstName" value="<%=(p != null) ? p.getFirstName() : ""%>" /><br/>
            Last name: <input type="text" name="lastName" value="<%=(p != null) ? p.getLastName() : ""%>" /><br/>
            Birth date:     <input type="text" name="birthDate" value="<%=(p != null) ? sdf.format(p.getBirthDate()) : ""%>" /><br/>
            Salary: <input type="text" name="salary" value="<%=(p != null) ? p.getSalary() : ""%>" /><br/>
            <input type="submit" value="Save" /><br/>
            <a href="index.jsp">Cancel</a><br/>
            <%EMF.returnEntityManager(em);
            %>
        </form>
    </body>
</html>
