
<%@page import="lt.bit.projektas.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="lt.bit.projektas.Person"%>
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
           
            try{
                id = new Integer(idString);
            } catch (Exception ex) {
                
            }
          
            
            Person p = new Person ();
            
            if( id != null){
                 p = em.find(Person.class, id);
            } 
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthDateString = (p != null && p.getBirthDate() != null) ? birthDateString = sdf.format(p.getBirthDate()) : "";
            String salaryString = (p != null && p.getSalary() != null) ? p.getSalary().toString() : "";
        %>
        <form action="editJPA" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : ""%>" />
            First name: <input type="text" name="firstName" value="<%=(p != null) ? p.getFirstName() : ""%>" /><br/>
            Last name: <input type="text" name="lastName" value="<%=(p != null) ? p.getLastName() : ""%>" /><br/>
            Birth date: <input type="text" name="birthDate" value="<%=birthDateString%>" /><br/>
            Salary: <input type="text" name="salary" value="<%=salaryString%>" /><br/>
            <input type="submit" value="Save" /><br/>
            <a href="index.jsp">Cancel</a><br/>
        </form>
           
    </body>
</html>
