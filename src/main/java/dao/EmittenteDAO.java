package dao;

import Exceptions.NotFoundException;
import entities.DistributoreAutomatico;
import entities.Emittente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class EmittenteDAO {
    private final EntityManager em;

    public EmittenteDAO(EntityManager em) {
        this.em = em;
    }

    //save
    public void save(Emittente emittente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(emittente);
        transaction.commit();
    }

    //find by ID
    public Emittente trovaPerId(long id){
        em.
    }

    //fuori_servizio
    public void setFuoriServizio(long id) {
        TypedQuery<DistributoreAutomatico> query = em.createQuery("SELECT d From DistributoreAutomatico d WHERE d.id = :id", DistributoreAutomatico.class);
        query.setParameter("id", id);
        DistributoreAutomatico found = query.getSingleResult();
        if (found == null) throw new NotFoundException(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        found.setIn_servizio(false);
        transaction.commit();
        System.out.println("Il sistema è stato aggiornato.");
    }
}
