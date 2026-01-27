package dao;

import entities.Utente;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("Utente " + utente.getNome() + " salvato!");
    }

    public Utente getById(UUID id) {
        Utente found = em.find(Utente.class, id);
        if (found == null) {
            throw new NotFoundException(id);
        }
        return found;
    }
}
