<%@page import="duomenys.EMF"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="duomenys.Person"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
            
            
            Person p = null;
            EntityManager em = EMF.getEntityManager();
            if(id != null){
                //EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication3_CRUD_JPAPU");             
                p = em.find(Person.class, id);
                //em.close();
            }
            
            if (p == null){
                p = new Person();
            }
            

            DateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
            

            
        %>
        <form action="edit" method="POST">
            <input type="hidden" name="id" value="<%=(p.getId() != null) ? p.getId() : "" %>" />
            First name: <input type="text" name="firstName" value="<%=(p.getId() != null && p.getFirstName() != null) ? p.getFirstName() : "" %>" /><br/>
            Last name: <input type="text" name="lastName" value="<%=(p.getId() != null && p.getLastName() != null) ? p.getLastName() : "" %>" /><br/>
            Date of Birthday: <input type="date" name="birthDate" value="<%=(p.getId() != null) && p.getBirthDate() != null ? format.format(p.getBirthDate()) : "" %>" /><br/>
            Salary: <input type="text" name="salary" value="<%=(id != null)&&(p.getSalary() != null) ? p.getSalary().toString() : "" %>" /><br/>
            
            <input type="submit" value="Save" /><br/>
            <a href="index.jsp">Cancel</a><br/>
        </form>
        
        <%
                EMF.returnEntityManager(em);  //emf.close();
        %>
            
    </body>
</html>
