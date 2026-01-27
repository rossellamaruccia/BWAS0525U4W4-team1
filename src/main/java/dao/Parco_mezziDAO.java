package dao;

import entities.Parco_mezzi;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.UUID;

public class Parco_mezziDAO {
    private final EntityManager em;
    public Parco_mezziDAO(EntityManager em) {
        this.em = em;
    }


    public void saveParco_mezzi(Parco_mezzi newParco_mezzi) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newParco_mezzi);
        transaction.commit();
    }
    public void findByIdAndDelete(UUID id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Parco_mezzi> query = em.createQuery("DELETE FROM Parco_mezzi a WHERE a.id = :id", Parco_mezzi.class);
        query.setParameter("id", id);
        String Deleted = String.valueOf(query.executeUpdate());
        transaction.commit();

    }
    public Parco_mezzi findById(UUID id) {
        TypedQuery<Parco_mezzi> query = em.createQuery(
                "SELECT c FROM Parco_mezzi c WHERE c.id = :id",
                Parco_mezzi.class
        );
        query.setParameter("id", id);

        return query.getSingleResult();


    }
}
