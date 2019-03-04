
<%@page import="lt.bit.zmones.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.List"%>
<%@page import="lt.bit.db.Address"%>
<%@page import="lt.bit.db.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            EntityManager em = EMF.getEntityManager();

            String idString = request.getParameter("id");
            String pidString = request.getParameter("pId");
            Integer id = null;
            Integer pId = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }
            try {
                pId = new Integer(pidString);
            } catch (Exception ex) {
            }
            Person p = null;
            try {
                p = em.find(Person.class, pId);
            } catch (Exception ex) {
            }
            Address adr = null;
            try {
                adr = em.find(Address.class, id);
            } catch (Exception ex) {
            }
            if (adr == null) {
                adr = new Address();
               
            }
            if (p==null) {
            p= adr.getPer();    
            }
            
        %>
        <form action="editAdr" method="POST">

            <input type="hidden" name="id" value="<%=(adr != null) ? adr.getId() : ""%>" />
            <input type="hidden" name="pId" value="<%=(p != null) ? p.getId() : ""%>" />


            Adress: <input type="text" name="address" value="<%=(adr.getAddress() != null) ? adr.getAddress() : ""%>" /><br/>
            City: <input type="text" name="city" value="<%=(adr.getCity() != null) ? adr.getCity() : ""%>" /><br/>
            Zip:     <input type="text" name="postalCode" value="<%=(adr.getPostalCode() != null) ? adr.getPostalCode() : ""%>" /><br/>

            <input type="submit" value="Save" /><br/>
            <a href="adressByPerson.jsp?id=<%=(p != null) ? p.getId() : "" %>">Cancel</a><br/>
        </form>
        <%EMF.returnEntityManager(em);%>
    </body>
</html>



            