package dao;


import entities.Manutenzione;
import entities.Parco_mezzi;
import enums.StatoManutenzione;
import enums.StatoMezzo;
import exceptions.NotFoundException;
import exceptions.NotPossibleException;
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
        TypedQuery<Manutenzione> query = em.createQuery("SELECT m FROM Manutenzione m WHERE m.mezzo = :mezzo AND m.statoManutenzione = IN_CORSO", Manutenzione.class);
        query.setParameter("mezzo", manutenzione.getMezzo());

        if (query.getSingleResultOrNull() != null) {
            throw new NotPossibleException(manutenzione.getMezzo().getId().toString());
        } else {

            EntityTransaction transaction = em.getTransaction();
            Parco_mezzi mezzo = manutenzione.getMezzo();
            transaction.begin();

            em.persist(manutenzione);

            manutenzione.setStatoManutenzione(StatoManutenzione.IN_CORSO);

            mezzo.setStatoMezzo(StatoMezzo.IN_MANUTENZIONE);

            transaction.commit();
            //System.out.println("Manutenzione con id: " + manutenzione.getId() + " salvata correttamente!");
        }
    }

    public Manutenzione trovaPerId(String id) {
        Manutenzione found = em.find(Manutenzione.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void trovaPerIdEcancella(String id) {
        Manutenzione found = this.trovaPerId(id);
        if (found == null) throw new NotFoundException(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        //System.out.println("Manutenzione al mezzo con id: " + found.getMezzo() + " eliminata con successo!");
    }

    public void fineManutenzione(Parco_mezzi mezzo) {
        TypedQuery<Manutenzione> query = em.createQuery("SELECT m FROM Manutenzione m WHERE m.mezzo=:mezzo AND m.statoManutenzione=IN_CORSO", Manutenzione.class);
        query.setParameter("mezzo", mezzo);
        Manutenzione m1 = query.getSingleResult();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        m1.setFineManutenzione();

        m1.setStatoManutenzione(StatoManutenzione.FINITA);

        mezzo.setStatoMezzo(StatoMezzo.IN_FUNZIONE);

        transaction.commit();

        //System.out.println("Manutenzione al mezzo: " + mezzo.getId() + " finita con successo");
    }

    public int manutenzioniPerMezzo(Parco_mezzi mezzo) {
        TypedQuery<Manutenzione> query = em.createQuery("SELECT m from Manutenzione m WHERE m.mezzo=:mezzo", Manutenzione.class);
        query.setParameter("mezzo", mezzo);
        return query.getResultList().size();
    }

    //impossibilitare piú manutenzioni
    //somma dei periodi di manutenzione


}
