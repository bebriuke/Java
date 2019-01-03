package lt.bit.rest;

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
import lt.bit.db.Contact;
import lt.bit.db.EMF;
import lt.bit.db.Person;

@Path("person/{personId}/contact")
public class ContactREST {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAll(@Context HttpServletRequest request, @PathParam("personId") Integer personId) {
        if (personId == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        Person p = em.find(Person.class, personId);
        if (p != null) {
            return p.getContacts();
        }
        return null;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getOne(@Context HttpServletRequest request, @PathParam("personId") Integer personId, @PathParam("id") Integer id) {
        if (personId == null) {
            return null;
        }
        if (id == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        Contact c = em.find(Contact.class, id);
        // Make sure that specified contact belongs to specified person
        if (personId.equals(c.getPerson().getId())) {
            return c;
        }
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Contact add(@Context HttpServletRequest request, @PathParam("personId") Integer personId, Contact c) {
        if (personId == null) {
            return null;
        }
        // Do not add if contact is not provided
        if (c == null) {
            return null;
        }
        // Set id to null to make sure that new record will be created
        c.setId(null);
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = EMF.getTransaction(em);
        // Every contact should belong to some person - find it
        Person p = em.find(Person.class, personId);
        // If person is not found - do not add contact
        if (p == null) {
            return null;
        }
        // Set person property to specify to whom belongs this new contact
        c.setPerson(p);
        em.persist(c);
        EMF.commitTransaction(tx);
        return c;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Contact update(@Context HttpServletRequest request, @PathParam("personId") Integer personId, @PathParam("id") Integer id, Contact c) {
        if (personId == null) {
            return null;
        }
        if (id == null) {
            return null;
        }
        if (c == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = EMF.getTransaction(em);
        Contact realContact = em.find(Contact.class, id);
        // If contact is not found or belongs to another person - do not update
        if (realContact == null || !personId.equals(realContact.getPerson().getId())) {
            EMF.rollbackTransaction(tx);
            return null;
        }
        realContact.setType(c.getType());
        realContact.setContact(c.getContact());
        EMF.commitTransaction(tx);
        return c;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact delete(@Context HttpServletRequest request, @PathParam("personId") Integer personId, @PathParam("id") Integer id) {
        if (personId == null) {
            return null;
        }
        if (id == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = EMF.getTransaction(em);
        Contact c = em.find(Contact.class, id);
        // If contact is not found or belongs to another person - do not delete
        if (c == null || !personId.equals(c.getPerson().getId())) {
            EMF.rollbackTransaction(tx);
            return null;
        }
        em.remove(c);
        EMF.commitTransaction(tx);
        return c;
    }

}
