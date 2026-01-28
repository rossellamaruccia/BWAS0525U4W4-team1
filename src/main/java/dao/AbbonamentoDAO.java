package dao;

import entities.Abbonamento;
import entities.Tessera;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.UUID;

public class AbbonamentoDAO {

    private final EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    //Salva abbonamento
    public void save(Abbonamento abbonamento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(abbonamento);
        transaction.commit();
        System.out.println("Abbonamento " + abbonamento.getId() + " salvato correttamente");
    }


    public Abbonamento findById(String id) {
        Abbonamento found = em.find(Abbonamento.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    //Elimina Abbonamento
    public void deleteById(String id) {
        Abbonamento found = findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Abbonamento con id " + id + " eliminato con successo");
    }

    // Trova abbonamento per numero tessera
    public Abbonamento findByTessera(UUID tesseraId) {
        TypedQuery<Abbonamento> query = em.createQuery(
                "SELECT a FROM Abbonamento a WHERE a.tessera.tesseraId = :tesseraId",
                Abbonamento.class
        );
        query.setParameter("tesseraId", tesseraId);
        return query.getSingleResult();
    }

    // Verifica se l'abbonamento è scaduto
    public boolean verificaValidita(UUID tesseraId) {
        try {
            Abbonamento abbonamento = findByTessera(tesseraId);
            return abbonamento.getDataScadenza().isAfter(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }
}
