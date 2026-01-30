package dao;

import entities.Parco_mezzi;
import entities.Percorrenza_tratta;
import entities.Tratta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PercorrenzaTrattaDAO {

    private final EntityManager em;

    public PercorrenzaTrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Percorrenza_tratta pt) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(pt);
        transaction.commit();
    }

    public double mediaPercorrenzeEffettive(Tratta tratta, Parco_mezzi mezzo) {
        EntityTransaction transaction = em.getTransaction();
        TypedQuery<Percorrenza_tratta> query = em.createQuery("SELECT p FROM Percorrenza_tratta p WHERE p.tratta = :tratta AND p.mezzo = :mezzo", Percorrenza_tratta.class);
        query.setParameter("tratta", tratta);
        query.setParameter("mezzo", mezzo);
        List<Percorrenza_tratta> results = query.getResultList();
        double somma = 0;
        for (Percorrenza_tratta r : results) {
            somma += r.getPercorrenza_effettiva();
        }
        return Math.ceil(somma / results.size());
    }
}
