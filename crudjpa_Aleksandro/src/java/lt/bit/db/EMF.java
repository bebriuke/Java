package lt.bit.db;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class EMF {

    private static final String PERSISTENCE_UNIT_NAME = "crudjpaPU";
    private static final Logger log = Logger.getLogger(EMF.class.getName());

    protected static EntityManagerFactory emf;

    public static EntityManagerFactory get() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }

    public static EntityManager getEntityManager()
            throws PersistenceException {
        return get().createEntityManager();
    }

    public static void returnEntityManager(EntityManager em) {
        if (em != null) {
            try {
                if (em.isOpen()) {
                    em.close();
                }
            } catch (PersistenceException ex) {
                log.log(Level.WARNING, "Failed to close EntityManager.", ex);
            }
        }
    }

    public static EntityTransaction getTransaction(EntityManager em) {
        if (em != null) {
            EntityTransaction tx = em.getTransaction();
            if (!tx.isActive()) {
                tx.begin();
            }
            return tx;
        } else {
            throw new PersistenceException("Entity manager not provided.");
        }
    }

    public static void commitTransaction(EntityTransaction tx) {
        if (tx != null) {
            if (tx.isActive()) {
                tx.commit();
            }
        }
    }

    public static void rollbackTransaction(EntityTransaction tx) {
        if (tx != null) {
            if (tx.isActive()) {
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    log.log(Level.WARNING, "Unexpected exception while rolling back transaction", ex);
                }
            }
        }
    }
}
