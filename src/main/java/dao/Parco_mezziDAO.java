package dao;

import entities.Bus;
import entities.Parco_mezzi;
import entities.Tram;
import exceptions.NotFoundException;
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
        if (newParco_mezzi instanceof Bus) {
            System.out.println("Bus con id " + newParco_mezzi.getId() + " salvato correttamente!");
        } else if (newParco_mezzi instanceof Tram) {
            System.out.println("Tram con id " + newParco_mezzi.getId() + " salvato correttamente!");
        }
    }

    public void findByIdAndDelete(String id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Parco_mezzi> query = em.createQuery("DELETE FROM Parco_mezzi a WHERE a.id = :id", Parco_mezzi.class);
        query.setParameter("id", UUID.fromString(id));
        String Deleted = String.valueOf(query.executeUpdate());
        transaction.commit();

    }

    public Parco_mezzi findById(String id) {
        // Semplice, veloce e gestisce automaticamente l'ereditarietà
        Parco_mezzi found = em.find(Parco_mezzi.class, UUID.fromString(id));
        if (found == null) {
            throw new NotFoundException(id);
        }
        return found;
    }
}
