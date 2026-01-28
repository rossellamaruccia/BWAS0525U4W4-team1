package dao;

import entities.Biglietto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import exceptions.NotFoundException;

import java.util.UUID;

public class BigliettoDAO {

    private final EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaBiglietto(Biglietto biglietto) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(biglietto);

        transaction.commit();

        System.out.println("Il biglietto " + biglietto.getId() + " è stato salvato con successo");
    }

    public Biglietto trovaBigliettoDaId(UUID id) {

        Biglietto found = em.find(Biglietto.class, id);

        if (found == null) {
            throw new NotFoundException(id.toString());
        }
        return found;
    }

    public void cancellaBigliettoDaId(UUID id) {
        Biglietto found = trovaBigliettoDaId(id);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Biglietto con id " + id + " eliminato con successo");
    }

}
