/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmem;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lt.bit.db.Address;
import lt.bit.db.Person;

import lt.bit.zmones.EMF;

/**
 *
 * @author trolis
 */
@WebServlet(name = "editAdressServlet", urlPatterns = {"/editAdr"})
public class EditAdressServlet extends HttpServlet {

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

        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");
        
        Person p = em.find(Person.class, pid);

        try {
            EntityTransaction tx = EMF.getTransaction(em);

            if (id != null) {
                Address adr = em.find(Address.class, id);
                adr.setAddress(address);
                adr.setCity(city);
                adr.setPostalCode(postalCode);

            } else {

                Address adr = new Address(address, city, postalCode);

                adr.setPer(p);


                em.persist(adr);
            }
            EMF.commitTransaction(tx);
        } catch (Exception ex) {
            System.out.println("klaida");
        } finally {
            EMF.returnEntityManager(em);
        }

        response.sendRedirect("adressByPerson.jsp?id=" + pid);

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
