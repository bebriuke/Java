/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmem;

import duomenys.Address;
import duomenys.EMF;
import duomenys.Person;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurate Valatkevicien
 */
@WebServlet(name = "EditAddress", urlPatterns = {"/EditAddress"})
public class EditAddress extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
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
        
        
        
        String adresas = request.getParameter("address");
        String miestas = request.getParameter("city");
        String pastoKodas = request.getParameter("pk");
       
        EntityManager em = EMF.getEntityManager();
        EntityTransaction tx = EMF.getTransaction(em);
        Address a;
            if (ida != null) {
                a = em.find(Address.class, ida);    
                a.setAddress(adresas);
                a.setCity(miestas);
                a.setPostalCode(pastoKodas);           
                em.persist(a); // nebūtinas, hipernatas pats surašys
                
            } else {
                Person p = em.find(Person.class, id);
                a = new Address(); 
                a.setAddress(adresas);
                a.setCity(miestas);
                a.setPostalCode(pastoKodas);
                a.setPerson(p);
                em.persist(a);
            }
            EMF.commitTransaction(tx);
            EMF.returnEntityManager(em);
        
        
        
        response.sendRedirect("adress.jsp?id="+id);
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
