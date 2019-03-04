
package crudmem;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lt.bit.db.Contacts;
import lt.bit.db.Person;

import lt.bit.zmones.EMF;

/**
 *
 * @author trolis
 */
@WebServlet(name = "editContactsServlet", urlPatterns = {"/editCon"})
public class EditContactsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException {
        request.setCharacterEncoding("UTF-8");
        String idString = request.getParameter("id");
        String pidString = request.getParameter("pId");

        Integer id = null;
        Integer pid = null;
        try {
            id = new Integer(idString);

        } catch (Exception ex) {
        }
        try {
            pid = new Integer(pidString);
        } catch (Exception ex) {
        }

        EntityManager em = EMF.getEntityManager();

        String type = request.getParameter("type");
        String contact = request.getParameter("contact");
        
        Person p = em.find(Person.class, pid);

        try {
            EntityTransaction tx = EMF.getTransaction(em);

            if (id != null) {
                Contacts con = em.find(Contacts.class, id);
                con.setType(type);
                con.setContact(contact);

            } else {

                Contacts con = new Contacts(type, contact);

                con.setPers(p);

                em.persist(con);
            }
            EMF.commitTransaction(tx);
        } catch (Exception ex) {
            System.out.println("klaida");
        } finally {
            EMF.returnEntityManager(em);
        }

        response.sendRedirect("contactByPerson.jsp?id=" + pid);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
