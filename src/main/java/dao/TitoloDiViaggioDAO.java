package dao;

import entities.Abbonamento;
import entities.Biglietto;
import entities.Parco_mezzi;
import entities.TitoloDiViaggio;
import enums.FrequenzaAbbonamento;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
//        if (titolo instanceof Biglietto) {
//            System.out.println("Biglietto con id " + titolo.getId() + " salvato correttamente!");
//        } else if (titolo instanceof Abbonamento) {
//            System.out.println("Abbonamento con id " + titolo.getId() + " salvato correttamente!");
//        }
    }

    public TitoloDiViaggio trovaTitoloDaId(String id) {

        TitoloDiViaggio found = em.find(TitoloDiViaggio.class, UUID.fromString(id));

        if (found == null) {
            throw new NotFoundException(id);
        }
        return found;
    }

    public void cancellaTitoloDaId(String id) {
        TitoloDiViaggio found = trovaTitoloDaId(id);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        //System.out.println("Titolo con id " + id + " eliminato con successo");
    }

    public List<TitoloDiViaggio> trovaTitoliperEmittenteEDate(String emittente_id, LocalDate startDate, LocalDate endDate) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<TitoloDiViaggio> query = em.createQuery("SELECT t FROM TitoloDiViaggio t WHERE t.emittente_id = :emittente_id AND t.data_emissione > :startDate AND t.data_emissione < :endDate", TitoloDiViaggio.class);
        query.setParameter("emittente_id", UUID.fromString(emittente_id));
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<TitoloDiViaggio> resultList = query.getResultList();
        transaction.commit();
        return resultList;
    }

    public List<Biglietto> cercaBigliettiVidimatiPerMezzo(Parco_mezzi mezzo) {
        TypedQuery<Biglietto> query = em.createQuery(
                "SELECT b FROM Biglietto b WHERE b.mezzo = :mezzo AND b.data_vidimazione IS NOT NULL",
                Biglietto.class);
        query.setParameter("mezzo", mezzo);
        return query.getResultList();
    }

    public List<Biglietto> cercaBigliettiPerDataVidimazione(int yyyy, int mm, int dd) {
        LocalDate date = LocalDate.of(yyyy, mm, dd);
        TypedQuery<Biglietto> query = em.createQuery("SELECT b FROM Biglietto b WHERE b.dataVidimazione = :date", Biglietto.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    // Trova abbonamento per numero tessera
    public Abbonamento findByTessera(String tesseraId) {
        TypedQuery<Abbonamento> query = em.createQuery(
                "SELECT a FROM Abbonamento a WHERE a.tessera.tesseraId = :tesseraId",
                Abbonamento.class
        );
        query.setParameter("tesseraId", UUID.fromString(tesseraId));
        return query.getSingleResult();
    }

    // Verifica se l'abbonamento è scaduto
    public boolean verificaValiditaAbbonamento(Abbonamento abb) {
        if (abb.getDataScadenza().isBefore(LocalDate.now())) {
            //System.out.println("Il tuo abbonamento é scaduto");
            return false;
        } else {
            //System.out.println("Il tuo abbonamento é valido fino al " + abb.getDataScadenza());
            return true;
        }
    }

    public void rinnovaAbbonamento(Abbonamento abb, FrequenzaAbbonamento durata) {
        this.verificaValiditaAbbonamento(abb);

        if (!this.verificaValiditaAbbonamento(abb)) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            abb.setDataEmissione();

            abb.setDurata(durata);

            abb.setDataScadenza();

            transaction.commit();

            //System.out.println("Il tuo abbonamento é stato rinnovato fino al " + abb.getDataScadenza());

        }
    }
}




