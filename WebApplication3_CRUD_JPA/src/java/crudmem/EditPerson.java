package crudmem;

import duomenys.EMF;
import duomenys.Person;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditPerson", urlPatterns = {"/edit"})
public class EditPerson extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        String idString = request.getParameter("id");
        Integer id = null;
        try {
            id = new Integer(idString);
        } catch (Exception ex) {
        }
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDateStr = request.getParameter("birthDate");
        DateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
        if (birthDateStr == null) birthDateStr = "";
        Date birthDate = null;
        try{
            birthDate = format.parse(birthDateStr);
        } catch (Exception ex){
            
        }
      
        
        String temp = request.getParameter("salary");     
        BigDecimal salary = null;
        if (!"".equals(temp)) {
            if (temp.contains(",")) temp = temp.replace(",",".");
            salary = new BigDecimal(temp);
        }
        
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication3_CRUD_JPAPU");
        EntityManager em = EMF.getEntityManager(); //atidarom
        try{
            
            EntityTransaction tx = EMF.getTransaction(em); //startuojam Transaction
            //tx.begin(); //em.getTransaction().begin();

            Person p;
            if (id != null) {
                p = em.find(Person.class, id);    
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setBirthDate(birthDate);
                p.setSalary(salary);            
                //em.persist(p);  nebūtinas, hipernatas pats surašys
            } else {
                p = new Person(firstName, lastName, birthDate, salary);    
                em.persist(p);
            }


            //tx.commit(); //em.getTransaction().commit();
            EMF.commitTransaction(tx); //commitinam Transactioną
            //em.close();
           // emf.close();
            
        }catch (Exception ex){
            System.out.println("Klaida");
        } finally{
            EMF.returnEntityManager(em); //uždarom
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditPerson.class.getName()).log(Level.SEVERE, null, ex);
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
