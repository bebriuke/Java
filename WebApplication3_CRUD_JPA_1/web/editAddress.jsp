<%-- 
    Document   : editAddress
    Created on : Nov 29, 2018, 12:34:31 PM
    Author     : Jurate Valatkevicien
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="duomenys.Address"%>
<%@page import="duomenys.EMF"%>
<%@page import="duomenys.Person"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="java.util.List"%>
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
            List <Address> a = p.getAddresses();
            if(a == null){
                a = new ArrayList();
            }
            
            //išsitraukiau reikalingą adresą
            Address aa = p.getAddressById(ida,  a);
            if(aa == null){
                aa = new Address();
            }
            
        %>
        
        
        <form action="EditAddress" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : "" %>" />
            <input type="hidden" name="ida" value="<%=p != null && aa != null ? ida : "" %>" />
            Adresas: <input type="text" name="address" value="<%=aa != null &&  aa.getAddress() != null ? aa.getAddress()  : "" %>" /><br/>
            Miestas: <input type="text" name="city" value="<%=aa != null &&  aa.getCity() != null ? aa.getCity()  : "" %>" /><br/>
            Pašto kodas: <input type="text" name="pk" value="<%=aa != null &&  aa.getPostalCode()!= null ? aa.getPostalCode()  : "" %>" /><br/>
            
            <input type="submit" value="Save" /><br/>
            <a href="adress.jsp?id=<%=p.getId()%>">Cancel</a><br/>
        </form>
        
        
        <%
             EMF.returnEntityManager(em);  //emf.close();
        %>
    </body>
</html>
