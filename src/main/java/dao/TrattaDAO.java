package dao;

import entities.Tratta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TrattaDAO {

    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(tratta);
        transaction.commit();
    }

    public void remove(UUID id_tratta) {
        EntityTransaction transaction = em.getTransaction();
        Tratta found = em.find(Tratta.class, id_tratta);
        transaction.begin();
        em.remove(found);
        transaction.commit();
    }
}
