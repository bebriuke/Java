package lt.bit.rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
import lt.bit.db.EMF;
import lt.bit.db.Person;

@Path("person")
public class PersonREST {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll(@Context HttpServletRequest request) {
        EntityManager em  = (EntityManager) request.getAttribute("em");
        Query q = em.createNamedQuery("Person.findAll");
        return q.getResultList();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getOne(@Context HttpServletRequest request, @PathParam("id") Integer id) {
        if (id == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        return em.find(Person.class, id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person add(@Context HttpServletRequest request, Person p) {
        if (p == null) {
            return null;
        }
        // Set id to null to make sure that new record will be created
        p.setId(null);
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = EMF.getTransaction(em);
        em.persist(p);
        EMF.commitTransaction(tx);
        return p;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person update(@Context HttpServletRequest request, @PathParam("id") Integer id, Person p) {
        if (id == null) {
            return null;
        }
        if (p == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = EMF.getTransaction(em);
        Person realPerson = em.find(Person.class, id);
        // If person does not exist - do not update
        if (realPerson == null) {
            EMF.rollbackTransaction(tx);
            return null;
        }
        realPerson.setFirstName(p.getFirstName());
        realPerson.setLastName(p.getLastName());
        realPerson.setBirthDate(p.getBirthDate());
        realPerson.setSalary(p.getSalary());
        EMF.commitTransaction(tx);
        return p;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person delete(@Context HttpServletRequest request, @PathParam("id") Integer id) {
        if (id == null) {
            return null;
        }
        EntityManager em  = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = EMF.getTransaction(em);
        Person p = em.find(Person.class, id);
        // If person exists - delete it
        if (p != null) {
            em.remove(p);
        }
        EMF.commitTransaction(tx);
        return p;
    }

}
