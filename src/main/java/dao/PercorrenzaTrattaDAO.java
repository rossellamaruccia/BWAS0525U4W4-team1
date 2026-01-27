package dao;

import entities.Percorrenza_tratta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PercorrenzaTrattaDAO {

    private final EntityManager em;

    public PercorrenzaTrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Percorrenza_tratta pt) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(pt);
        transaction.commit();
    }
}
