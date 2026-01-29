package dao;


import entities.Manutenzione;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.UUID;

public class ManutenzioneDAO {
    private final EntityManager em;

    public ManutenzioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Manutenzione manutenzione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(manutenzione);
        transaction.commit();
    }

    public Manutenzione trovaPerId(String id) {
        Manutenzione found = em.find(Manutenzione.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void trovaPerIdEcancella(String id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Manutenzione> query = em.createQuery("DELETE FROM Manutenzione a WHERE a.id = :id", Manutenzione.class);
        query.setParameter("id", id);
        String Deleted = String.valueOf(query.executeUpdate());
        transaction.commit();
    }

    //somma dei periodi di manutenzione


}
