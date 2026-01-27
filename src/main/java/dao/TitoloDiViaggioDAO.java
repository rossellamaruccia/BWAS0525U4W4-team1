package dao;

import entities.TitoloDiViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TitoloDiViaggioDAO {
    private final EntityManager em;

    public TitoloDiViaggioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(TitoloDiViaggio titolo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(titolo);
        transaction.commit();
    }
}
