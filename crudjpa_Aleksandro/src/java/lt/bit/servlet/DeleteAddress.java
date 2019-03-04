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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Aleksandras Novikovas <Aleksandras.Novikovas@gmail.com>
 */
@WebServlet(name = "DeleteAddress", urlPatterns = {"/deleteAddress"})
public class DeleteAddress extends HttpServlet {

    private static final Log log = LogFactory.getLog(DeleteAddress.class);

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
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = null;
        Integer personId = null;
        try {
            tx = EMF.getTransaction(em);
            Address a = em.find(Address.class, id);
            if (a != null) {
                personId = a.getPerson().getId();
                em.remove(a);
                EMF.commitTransaction(tx);
            }
        } catch (Exception ex) {
            log.error("Failure to remove address", ex);
            EMF.rollbackTransaction(tx);
        }
        if (personId != null) {
            response.sendRedirect("addresses.jsp?personId=" + personId);
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
