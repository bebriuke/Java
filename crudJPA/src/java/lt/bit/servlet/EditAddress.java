package lt.bit.servlet;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lt.bit.db.Address;
import lt.bit.db.EMF;
import lt.bit.db.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet(name = "EditAddress", urlPatterns = {"/editAddress"})
public class EditAddress extends HttpServlet {

    private static final Log log = LogFactory.getLog(EditAddress.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idString = request.getParameter("id");
        Integer id = null;
        try {
            id = new Integer(idString);
        } catch (Exception ex) {
        }
        String personIdString = request.getParameter("personId");
        Integer personId = null;
        try {
            personId = new Integer(personIdString);
        } catch (Exception ex) {
        }
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = null;
        Address a;
        Person p = null;
        try {
            tx = EMF.getTransaction(em);
            if (id != null) {
                a = em.find(Address.class, id);
                p = a.getPer();
            } else {
                a = new Address();
                if (personId != null) {
                    p = em.find(Person.class, personId);
                    a.setPer(p);
                }
            }
            a.setAddress(address);
            a.setCity(city);
            a.setPostalCode(postalCode);
            em.persist(a);
            EMF.commitTransaction(tx);
        } catch (Exception ex) {
            log.error("Error saving person address", ex);
            EMF.rollbackTransaction(tx);
        }
        if (p != null) {
            response.sendRedirect("addresses.jsp?personId=" + p.getId());
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
