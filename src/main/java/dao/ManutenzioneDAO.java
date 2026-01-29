package dao;


import entities.Manutenzione;
import entities.Parco_mezzi;
import enums.StatoManutenzione;
import enums.StatoMezzo;
import exceptions.NotFoundException;
import exceptions.NotPossibleException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TypedQuery;

import java.util.UUID;

public class ManutenzioneDAO {
    private final EntityManager em;

    public ManutenzioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Manutenzione manutenzione) {
        try {
            EntityTransaction transaction = em.getTransaction();
            Parco_mezzi mezzo = manutenzione.getMezzo();
            transaction.begin();

            em.persist(manutenzione);

            manutenzione.setStatoManutenzione(StatoManutenzione.IN_CORSO);

            mezzo.setStatoMezzo(StatoMezzo.IN_MANUTENZIONE);

            transaction.commit();
            System.out.println("Manutenzione con id: " + manutenzione.getId() + " salvata correttamente!");
        } catch (RollbackException ex) {
            throw new NotPossibleException(manutenzione.getMezzo().getId().toString());
        }
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

    public void fineManutenzione(Parco_mezzi mezzo) {
        TypedQuery<Manutenzione> query = em.createQuery("SELECT m FROM Manutenzione m WHERE m.mezzo=:mezzo", Manutenzione.class);
        query.setParameter("mezzo", mezzo);
        Manutenzione m1 = query.getSingleResult();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        m1.setFineManutenzione();

        m1.setStatoManutenzione(StatoManutenzione.FINITA);

        mezzo.setStatoMezzo(StatoMezzo.IN_FUNZIONE);

        transaction.commit();

        System.out.println("Manutenzione al mezzo: " + mezzo.getId() + " finita con successo");
    }

    //impossibilitare piú manutenzioni
    //somma dei periodi di manutenzione


}
