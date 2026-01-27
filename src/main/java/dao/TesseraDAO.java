package dao;

import entities.Tessera;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class TesseraDAO {

    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaTessera(Tessera tessera) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(tessera);

        transaction.commit();

        System.out.println("La tessera " + tessera.getIdTessera() + " é stata salvata con successo");
    }

    public Tessera trovaTesseraDalNumero(String tesseraId) {

        Tessera found = em.find(Tessera.class, tesseraId);

        if (found == null) {
            throw new NotFoundException(tesseraId);
        }
        return found;
    }

    public void cancellaTesseraDaId(String tesseraId) {
        Tessera found = trovaTesseraDalNumero(tesseraId);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Tessera con numero " + tesseraId + " eliminata con successo");
    }

}
