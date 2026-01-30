package dao;

import entities.Biglietto;
import entities.Parco_mezzi;
import entities.Utente;
import enums.StatoMezzo;
import exceptions.NotFoundException;
import exceptions.NotPossibleException;
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
        System.out.println("Utente " + utente.getNome() + " " + utente.getCognome() + " salvato! id: " + utente.getUtenteId());
    }

    public Utente getById(String id) {
        Utente found = em.find(Utente.class, UUID.fromString(id));
        if (found == null) {
            throw new NotFoundException(id);
        }
        return found;
    }

    public void removeById(String id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Utente found = em.find(Utente.class, UUID.fromString(id));
        if (found == null) {
            throw new NotFoundException(id);
        }
        em.remove(found);
        transaction.commit();
        System.out.println("Utente cancellato.");
    }

    public void vidimaBiglietto(Biglietto biglietto, Parco_mezzi mezzo) {
        if (mezzo == null) {
            System.out.println("Mezzo non trovato");
            return;
        } else if (mezzo.getStatoMezzo() != StatoMezzo.IN_FUNZIONE) {
            throw new NotFoundException(mezzo.getId().toString());
        }

        if (biglietto == null) {
            throw new NotFoundException();
        } else if (biglietto.getDataVidimazione() != null) {
            throw new NotPossibleException("Biglietto giá vidimato");
        } else {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            biglietto.setDataVidimazione(LocalDate.now());
            biglietto.setMezzo(mezzo);
            //cancelliamo il biglietto?

            transaction.commit();
            System.out.println("Biglietto vidimato sul " + mezzo.getId() + " sulla tratta " + mezzo.getTratta().getPartenza() + "-" + mezzo.getTratta().getCapolinea());
        }
    }
}
