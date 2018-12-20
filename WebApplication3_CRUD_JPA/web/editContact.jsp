<%-- 
    Document   : editContact
    Created on : Dec 18, 2018, 12:56:44 PM
    Author     : Jurate Valatkevicien
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="duomenys.Contacts"%>
<%@page import="duomenys.Person"%>
<%@page import="duomenys.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Contact</title>
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
            
            EntityManager em = EMF.getEntityManager();
            Person p = null;
            if(id != null){
                
                //EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication3_CRUD_JPAPU");
                p = em.find(Person.class, id);
                //em.close();
                
            }
            
            if (p == null){
                p = new Person();
            }
            
            
            //Pasiėmiau adresų sąrašą
            List <Contacts> a = p.getContacts();
            if(a == null){
                a = new ArrayList();
            }
            
            //išsitraukiau reikalingą adresą
            Contacts aa = p.getContactById(ida,  a);
            if(aa == null){
                aa = new Contacts();
            }
            
        %>
        
        
        <form action="editContact" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : "" %>" />
            <input type="hidden" name="ida" value="<%=p != null && aa != null ? ida : "" %>" />
            Type: <input type="text" name="type" value="<%=aa != null &&  aa.getType()!= null ? aa.getType(): "" %>" /><br/>
            Address: <input type="text" name="contact" value="<%=aa != null &&  aa.getAddres()!= null ? aa.getAddres(): "" %>" /><br/>
            
            <input type="submit" value="Save" /><br/>
            <a href="adress.jsp?id=<%=p.getId()%>">Cancel</a><br/>
        </form>
        
        
        <%
             EMF.returnEntityManager(em);  //emf.close();
        %>
    </body>
</html>
