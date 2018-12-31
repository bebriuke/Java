package rest;

import duomenys.Address;
import duomenys.EMF;
import duomenys.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("person/{personId}/address")
public class AddressREST {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> getAll(@Context HttpServletRequest request, @PathParam("personId") Integer personId) {
        if (personId == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        Person p = em.find(Person.class, personId);
        if (p != null) {
            return p.getAddresses();
        }
        return null;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Address getOne(@Context HttpServletRequest request, @PathParam("personId") Integer personId, @PathParam("id") Integer id) {
        if (personId == null) {
            return null;
        }
        if (id == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        Address a = em.find(Address.class, id);
        // Make sure that specified address belongs to specified person
        if (personId.equals(a.getPerson().getId())) {
            return a;
        }
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Address add(@Context HttpServletRequest request, @PathParam("personId") Integer personId, Address a) {
        if (personId == null) {
            return null;
        }
        // Do not add if address is not provided
        if (a == null) {
            return null;
        }
        // Set id to null to make sure that new record will be created
        a.setId(null);
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = EMF.getTransaction(em);
        // Every address should belong to some person - find it
        Person p = em.find(Person.class, personId);
        // If person is not found - do not add address
        if (p == null) {
            return null;
        }
        // Set person property to specify to whom belongs this new address
        a.setPerson(p);
        em.persist(a);
        EMF.commitTransaction(tx);
        return a;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Address update(@Context HttpServletRequest request, @PathParam("personId") Integer personId, @PathParam("id") Integer id, Address a) {
        if (personId == null) {
            return null;
        }
        if (id == null) {
            return null;
        }
        if (a == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = EMF.getTransaction(em);
        Address realAddress = em.find(Address.class, id);
        // If address is not found or belongs to another person - do not update
        if (realAddress == null || !personId.equals(realAddress.getPerson().getId())) {
            EMF.rollbackTransaction(tx);
            return null;
        }
        realAddress.setAddress(a.getAddress());
        realAddress.setCity(a.getCity());
        realAddress.setPostalCode(a.getPostalCode());
        EMF.commitTransaction(tx);
        return a;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Address delete(@Context HttpServletRequest request, @PathParam("personId") Integer personId, @PathParam("id") Integer id) {
        if (personId == null) {
            return null;
        }
        if (id == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = EMF.getTransaction(em);
        Address a = em.find(Address.class, id);
        // If address is not found or belongs to another person - do not delete
        if (a == null || !personId.equals(a.getPerson().getId())) {
            EMF.rollbackTransaction(tx);
            return null;
        }
        em.remove(a);
        EMF.commitTransaction(tx);
        return a;
    }

}
