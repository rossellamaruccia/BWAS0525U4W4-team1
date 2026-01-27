package dao;


import exceptions.NotFoundException;
import entities.Manutenzione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.UUID;

public class ManutenzioneDAO {
    private final EntityManager em;
    public ManutenzioneDAO(EntityManager em) {
        this.em = em;
    }
    //save
    public void save(Manutenzione manutenzione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(manutenzione);
        transaction.commit();
    }
    //find by ID
    public Manutenzione trovaPerId(long id) {
        Manutenzione found = em.find(Manutenzione.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
    //find by ID and delete
    public void trovaPerIdEcancella(UUID id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Manutenzione> query = em.createQuery("DELETE FROM Manutenzione a WHERE a.id = :id", Manutenzione.class);
        query.setParameter("id", id);
        String Deleted = String.valueOf(query.executeUpdate());
        transaction.commit();

    }

}
