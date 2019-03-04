
<%@page import="lt.bit.db.Contacts"%>
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
            Contacts con = null;
            try {
                con = em.find(Contacts.class, id);
            } catch (Exception ex) {
            }
            if (con == null) {
                con = new Contacts();
               
            }
            if (p==null) {
            p= con.getPers();    
            }
            
        %>
        <form action="editCon" method="POST">

            <input type="hidden" name="id" value="<%=(con != null) ? con.getId() : ""%>" />
            <input type="hidden" name="pId" value="<%=(p != null) ? p.getId() : ""%>" />


            Type: <input type="text" name="type" value="<%=(con.getType() != null) ? con.getType() : ""%>" /><br/>
            Contact:     <input type="text" name="contact" value="<%=(con.getContact() != null) ? con.getContact() : ""%>" /><br/>

            <input type="submit" value="Save" /><br/>
            <a href="contactByPerson.jsp?id=<%=(p != null) ? p.getId() : "" %>">Cancel</a><br/>
        </form>
        <%EMF.returnEntityManager(em);%>
    </body>
</html>



            