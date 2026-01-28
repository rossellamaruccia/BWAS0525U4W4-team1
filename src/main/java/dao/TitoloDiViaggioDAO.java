package dao;

import entities.Abbonamento;
import entities.Biglietto;
import entities.TitoloDiViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TitoloDiViaggioDAO {
    private final EntityManager em;

    public TitoloDiViaggioDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaTitoloDiViaggio(TitoloDiViaggio titolo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(titolo);
        transaction.commit();
        if (titolo instanceof Biglietto) {
            System.out.println("Biglietto con id " + titolo.getId() + " salvato correttamente!");
        } else if (titolo instanceof Abbonamento) {
            System.out.println("Abbonamento con id " + titolo.getId() + " salvato correttamente!");
        }
    }
}
