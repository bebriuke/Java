package crudmem;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lt.bit.db.Person;
import lt.bit.zmones.EMF;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet(name = "EditPerson", urlPatterns = {"/edit"})
public class EditPerson extends HttpServlet {

    private static final Log log = LogFactory.getLog(EditPerson.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        
        String idString = request.getParameter("id");
        Integer id = null;
        log.trace(idString);
        
        try {
            id = new Integer(idString);
        } catch (NumberFormatException ex) {
            log.error("blogas id", ex);
        }

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        EntityManager em = EMF.getEntityManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = null;
        BigDecimal salary = null;
        try {
            birthDate = sdf.parse(request.getParameter("birthDate"));
            salary = new BigDecimal(request.getParameter("salary"));
        } catch (Exception ex) {
        }

        try {
            EntityTransaction tx = EMF.getTransaction(em);
            if (id != null) {
                Person p = em.find(Person.class, id);
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setBirthDate(birthDate);
                p.setSalary(salary);

            } else {
                Person p = new Person();
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setBirthDate(birthDate);
                p.setSalary(salary);
                em.persist(p);

            }
            EMF.commitTransaction(tx);
        } catch (Exception ex) {
            log.error("Klaida", ex);
        } finally {
            EMF.returnEntityManager(em);
        }
        response.sendRedirect("index.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditPerson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            System.out.println("negeras blogas duomuo");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditPerson.class.getName()).log(Level.SEVERE, null, ex);

        } catch (NullPointerException e) {
            System.out.println("nullPointeris");
        }
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
