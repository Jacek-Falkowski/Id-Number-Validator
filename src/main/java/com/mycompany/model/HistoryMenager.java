package com.mycompany.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import java.util.List;

/**
 ** The HistoryMenager class provides methods to interact with the
 * database for persisting and retrieving HistoryObject instances.
 *
 * @author jfalkowski
 * @version 5.0
 */
public class HistoryMenager {

    /**
     * Persists the given object to the database.
     *
     * @param object the object to be persisted
     */
    public void persistObject(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    /**
     * Retrieves a list of HistoryObject instances from the database.
     *
     * @return a list of HistoryObject instances, or null if an error occurs
     */
    public List<HistoryObject> getObjectsFromDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT h FROM HistoryObject h");
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return null;
    }

}
