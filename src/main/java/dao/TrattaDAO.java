package dao;

import entities.Tratta;
import exceptions.NotFoundException;
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

    public void remove(String id_tratta) {
        EntityTransaction transaction = em.getTransaction();
        Tratta found = em.find(Tratta.class, UUID.fromString(id_tratta));
        transaction.begin();
        em.remove(found);
        transaction.commit();
    }

    public Tratta trovaPerID(String id) {
        Tratta found = em.find(Tratta.class, UUID.fromString(id));
        if (found == null) {
            throw new NotFoundException(id);
        }
        return found;
    }
}
