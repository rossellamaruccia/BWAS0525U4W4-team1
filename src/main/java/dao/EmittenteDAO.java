package dao;

import entities.DistributoreAutomatico;
import entities.Emittente;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.UUID;

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
        //System.out.println("Emittente con id: " + emittente.getId() + " salvato correttamente!");
    }

    //find by ID
    public Emittente trovaPerId(String id) {
        Emittente found = em.find(Emittente.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    //fuori_servizio
    public void setFuoriServizio(String id) {
        TypedQuery<DistributoreAutomatico> query = em.createQuery("SELECT d From DistributoreAutomatico d WHERE d.id = :id", DistributoreAutomatico.class);
        query.setParameter("id", id);
        DistributoreAutomatico found = query.getSingleResult();
        if (found == null) throw new NotFoundException(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        found.setIn_servizio(false);
        transaction.commit();
        //System.out.println("Il sistema è stato aggiornato.");
    }
}
