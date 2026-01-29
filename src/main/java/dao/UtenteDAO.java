package dao;

import entities.Biglietto;
import entities.Parco_mezzi;
import entities.Utente;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
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

    public Utente getById(String id) {
        Utente found = em.find(Utente.class, UUID.fromString(id));
        if (found == null) {
            throw new NotFoundException(id);
        }
        return found;
    }

    public void vidimaBiglietto(String bigliettoId, String mezzoId) {
        
        Parco_mezzi mezzo = em.find(Parco_mezzi.class, UUID.fromString(mezzoId));
        if (mezzo == null) {
            System.out.println("Mezzo non trovato");
            return;
        }

        Biglietto biglietto = em.find(Biglietto.class, UUID.fromString(bigliettoId));
        if (biglietto == null) {
            System.out.println("Biglietto non trovato");
        } else if (biglietto.getDataVidimazione() != null) {
            System.out.println("Biglietto già vidimato");
        } else {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            biglietto.setDataVidimazione(LocalDate.now());
            biglietto.setMezzo(mezzo);
            //cancelliamo il biglietto?

            transaction.commit();
            System.out.println("Biglietto vidimato sul mezzo " + mezzoId);
        }
    }
}
