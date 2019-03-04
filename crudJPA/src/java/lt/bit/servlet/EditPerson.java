package lt.bit.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lt.bit.db.EMF;
import lt.bit.db.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet(name = "EditPerson", urlPatterns = {"/edit"})
public class EditPerson extends HttpServlet {

    private static final Log log = LogFactory.getLog(EditPerson.class);

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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDateString = request.getParameter("birthDate");
        Date birthDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthDate = sdf.parse(birthDateString);
        } catch (Exception ex) {}
        String salaryString = request.getParameter("salary");
        BigDecimal salary = null;
        try {
            salary = new BigDecimal(salaryString);
        } catch (Exception ex) {}
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = null;
        try {
            tx = EMF.getTransaction(em);
            Person p;
            if (id != null) {
                p = em.find(Person.class, id);
            } else {
                p = new Person();
            }
            p.setFirstName(firstName);
            p.setLastName(lastName);
            p.setBirthDate(birthDate);
            p.setSalary(salary);
            em.persist(p);
            EMF.commitTransaction(tx);
        } catch (Exception ex) {
            log.error("Error saving person", ex);
            EMF.rollbackTransaction(tx);
        }
        response.sendRedirect("index.jsp");
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
